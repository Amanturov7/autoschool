package kg.amanturov.doska.service.impl;

import kg.amanturov.doska.Exceptions.NotFoundException;
import kg.amanturov.doska.RestResponse;
import kg.amanturov.doska.dto.LessonsDTO;
import kg.amanturov.doska.models.CommonReference;
import kg.amanturov.doska.models.Groups;
import kg.amanturov.doska.models.Lessons;
import kg.amanturov.doska.repository.GroupsRepository;
import kg.amanturov.doska.repository.LessonsRepository;
import kg.amanturov.doska.service.CommonReferenceService;
import kg.amanturov.doska.service.LessonsService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LessonsServiceImpl implements LessonsService {
    private final LessonsRepository lessonsRepository;
    private final GroupsRepository groupsRepository;
    private final CommonReferenceService commonReferenceService;

    public LessonsServiceImpl(LessonsRepository lessonsRepository, GroupsRepository groupsRepository, CommonReferenceService commonReferenceService) {
        this.lessonsRepository = lessonsRepository;
        this.groupsRepository = groupsRepository;
        this.commonReferenceService = commonReferenceService;
    }


    @Override
    public RestResponse save(LessonsDTO lessonsDTO) {
        try {
            Lessons lessons = toEntity(lessonsDTO);
            LocalDateTime now = LocalDateTime.now();
            Timestamp timestamp = Timestamp.valueOf(now);
            lessons.setCreatedAt(timestamp);
            lessons = lessonsRepository.save(lessons);
            return new RestResponse(RestResponse.Status.SUCCESS, toDTO(lessons));
        }
        catch (Exception e){
            return new RestResponse(RestResponse.Status.ERROR, null, e.getMessage());

        }
    }

    @Override
    public RestResponse update(Long id, LessonsDTO lessonsDTO) {
        Lessons updatedLesson = null;
        try {
            Lessons existingLesson = lessonsRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Journal not found"));
            updatedLesson = toEntity(lessonsDTO);
            updatedLesson.setId(existingLesson.getId());
            LocalDateTime now = LocalDateTime.now();
            Timestamp timestamp = Timestamp.valueOf(now);
            updatedLesson.setUpdatedAt(timestamp);
            updatedLesson.setCreatedAt(existingLesson.getCreatedAt());
            updatedLesson = lessonsRepository.save(updatedLesson);
            return new RestResponse(RestResponse.Status.SUCCESS, toDTO(updatedLesson)) ;
        } catch (RuntimeException e) {
            return new RestResponse(RestResponse.Status.ERROR, null, e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        Lessons lessons = lessonsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Journal not found"));
        lessonsRepository.delete(lessons);
    }

    @Override
    public RestResponse findById(Long id) {
        try {
            Lessons lessons = lessonsRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Journal not found"));
            return  new RestResponse(RestResponse.Status.SUCCESS, toDTO(lessons)) ;
        } catch (RuntimeException e) {
            return new RestResponse(RestResponse.Status.ERROR, null) ;
        }
    }

    @Override
    public RestResponse findAllByGroupsId(Long id) {
        try {
            Optional<Groups> groups = groupsRepository.findById(id);
            if(groups.isEmpty())
            {
                throw new NotFoundException("Group not found");
            }
            List<LessonsDTO> lessonsDTOS = lessonsRepository.findAllByGroupsId(id).stream()
                    .map(this::toDTO)
                    .toList();
            if(lessonsDTOS.isEmpty()){
                return new RestResponse(RestResponse.Status.SUCCESS,null,"No lessons found");
            }
            return new RestResponse(RestResponse.Status.SUCCESS,lessonsDTOS);
        } catch (Exception e) {
            return new RestResponse(RestResponse.Status.ERROR, null, e.getMessage());
        }
    }

    @Override
    public RestResponse findAllByLessonTypeAndGroupsId(Long typeId, Long groupId) {
        try {
            CommonReference referenceService = commonReferenceService.findById(typeId);
            if(referenceService == null)
            {
                throw new NotFoundException("Lesson type not found");
            }
            List<LessonsDTO> lessonsDTOS = lessonsRepository.findAllByLessonTypeAndGroupsId(referenceService,groupId).stream()
                    .map(this::toDTO)
                    .toList();
            if(lessonsDTOS.isEmpty()){
                return new RestResponse(RestResponse.Status.SUCCESS,null,"No lessons found");
            }
            return new RestResponse(RestResponse.Status.SUCCESS, lessonsDTOS);
        }
        catch (Exception e) {
           return new RestResponse(RestResponse.Status.ERROR, null, e.getMessage());
        }
    }


    @Override
    public RestResponse findAll() {
        try {
            List<LessonsDTO> lessonsDTOS = lessonsRepository.findAll().stream()
                    .map(this::toDTO)
                    .toList();
            if(lessonsDTOS.isEmpty()){
                return new RestResponse(RestResponse.Status.SUCCESS,null,"No lessons found");
            }
            return new RestResponse(RestResponse.Status.SUCCESS,lessonsDTOS);
        } catch (Exception e) {
            return new RestResponse(RestResponse.Status.ERROR, null, e.getMessage());
        }
    }

    private LessonsDTO toDTO(Lessons lessons) {
        LessonsDTO dto = new LessonsDTO();
        dto.setId(lessons.getId());
        dto.setCreatedAt(lessons.getCreatedAt());
        dto.setUpdatedAt(lessons.getUpdatedAt());
        dto.setName(lessons.getName());
        dto.setTimeRemain(lessons.getTimeRemain());
        dto.setIsArchived(lessons.getIsArchived());
        dto.setDescription(lessons.getDescription());
        dto.setGroupId(lessons.getGroups().getId());
        dto.setLessonType(lessons.getLessonType().getId());
        dto.setGroupId(lessons.getGroups().getId());
        return dto;
    }

    private Lessons toEntity(LessonsDTO dto) {
        Lessons lessons = new Lessons();
        lessons.setId(dto.getId());
        lessons.setDescription(dto.getDescription());
        if(Objects.nonNull(dto.getGroupId())){
            lessons.setGroups(groupsRepository.findById(dto.getGroupId()).get());
        }
        if(Objects.nonNull(dto.getLessonType())){
            lessons.setLessonType(commonReferenceService.findById(dto.getLessonType()));
        }
        lessons.setCreatedAt(dto.getCreatedAt());
        lessons.setUpdatedAt(dto.getUpdatedAt());
        lessons.setName(dto.getName());
        lessons.setTimeRemain(dto.getTimeRemain());
        lessons.setIsArchived(dto.getIsArchived());
        return lessons;
    }
}
