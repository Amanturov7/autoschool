package kg.amanturov.doska.service.impl;

import kg.amanturov.doska.dto.LessonsDTO;
import kg.amanturov.doska.models.Lessons;
import kg.amanturov.doska.repository.EmployeeRepository;
import kg.amanturov.doska.repository.LessonsRepository;
import kg.amanturov.doska.service.LessonsService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class LessonsServiceImpl implements LessonsService {
    private final LessonsRepository lessonsRepository;
    private final EmployeeRepository employeeRepository;

    public LessonsServiceImpl(LessonsRepository lessonsRepository, EmployeeRepository employeeRepository) {
        this.lessonsRepository = lessonsRepository;
        this.employeeRepository = employeeRepository;
    }


    @Override
    public LessonsDTO save(LessonsDTO lessonsDTO) {
        Lessons lessons = toEntity(lessonsDTO);
        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
        lessons.setCreatedAt(timestamp);
        lessons = lessonsRepository.save(lessons);
        return toDTO(lessons);
    }

    @Override
    public LessonsDTO update(Long id, LessonsDTO lessonsDTO) {
        Lessons existingLesson = lessonsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Journal not found"));
        Lessons updatedLesson = toEntity(lessonsDTO);
        updatedLesson.setId(existingLesson.getId());
        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
        updatedLesson.setUpdatedAt(timestamp);
        updatedLesson.setCreatedAt(existingLesson.getCreatedAt());
        updatedLesson = lessonsRepository.save(updatedLesson);
        return toDTO(updatedLesson);
    }

    @Override
    public void delete(Long id) {
        Lessons lessons = lessonsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Journal not found"));
        lessonsRepository.delete(lessons);
    }

    @Override
    public LessonsDTO findById(Long id) {
        Lessons lessons = lessonsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Journal not found"));
        return toDTO(lessons);
    }

    @Override
    public List<LessonsDTO> findAll() {
        return lessonsRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
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
        return dto;
    }

    private Lessons toEntity(LessonsDTO dto) {
        Lessons lessons = new Lessons();
        lessons.setId(dto.getId());
        lessons.setDescription(dto.getDescription());
        if(Objects.nonNull(dto.getEmployee())){
            lessons.setEmployee(employeeRepository.findById(dto.getEmployee()).get());
        }
        lessons.setCreatedAt(dto.getCreatedAt());
        lessons.setUpdatedAt(dto.getUpdatedAt());
        lessons.setName(dto.getName());
        lessons.setTimeRemain(dto.getTimeRemain());
        lessons.setIsArchived(dto.getIsArchived());
        return lessons;
    }
}
