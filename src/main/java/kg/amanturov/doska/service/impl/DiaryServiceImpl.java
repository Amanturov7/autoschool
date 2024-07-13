package kg.amanturov.doska.service.impl;

import kg.amanturov.doska.dto.DiaryDTO;
import kg.amanturov.doska.models.Diary;
import kg.amanturov.doska.repository.CommonReferenceRepository;
import kg.amanturov.doska.repository.DiaryRepository;
import kg.amanturov.doska.repository.UserRepository;
import kg.amanturov.doska.service.DiaryService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiaryServiceImpl implements DiaryService {
    private final DiaryRepository diaryRepository;
    private final CommonReferenceRepository commonReferenceRepository;
    private final UserRepository userRepository;

    public DiaryServiceImpl(DiaryRepository diaryRepository, CommonReferenceRepository commonReferenceRepository, UserRepository userRepository) {
        this.diaryRepository = diaryRepository;
        this.commonReferenceRepository = commonReferenceRepository;
        this.userRepository = userRepository;
    }

    @Override
    public DiaryDTO save(DiaryDTO diaryDTO) {
        Diary diary = toEntity(diaryDTO);
        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
        diary.setCreatedAt(timestamp);
        diary = diaryRepository.save(diary);
        return toDTO(diary);
    }

    @Override
    public DiaryDTO update(Long id, DiaryDTO diaryDTO) {
        Diary existingDiary = diaryRepository.findById(id).orElseThrow(() -> new RuntimeException("Diary not found"));
        Diary updatedDiary = toEntity(diaryDTO);
        updatedDiary.setId(existingDiary.getId());
        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
        updatedDiary.setUpdatedAt(timestamp);
        updatedDiary.setCreatedAt(existingDiary.getCreatedAt());
        updatedDiary = diaryRepository.save(updatedDiary);
        return toDTO(updatedDiary);
    }

    @Override
    public void delete(Long id) {
        Diary diary = diaryRepository.findById(id).orElseThrow(() -> new RuntimeException("Diary not found"));
        diaryRepository.delete(diary);
    }

    @Override
    public DiaryDTO findById(Long id) {
        Diary diary = diaryRepository.findById(id).orElseThrow(() -> new RuntimeException("Diary not found"));
        return toDTO(diary);
    }

    @Override
    public List<DiaryDTO> findAll() {
        return diaryRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private DiaryDTO toDTO(Diary diary) {
        DiaryDTO dto = new DiaryDTO();
        dto.setId(diary.getId());
        dto.setCreatedAt(diary.getCreatedAt());
        dto.setUpdatedAt(diary.getUpdatedAt());
        dto.setMark(diary.getMark());
        if (diary.getSkills() != null) {
            dto.setSkillsId(diary.getSkills().getId());
        }
        if (diary.getCategory() != null) {
            dto.setCategoryId(diary.getCategory().getId());
        }
        if (diary.getUser() != null) {
            dto.setUserId(diary.getUser().getId());
        }
        return dto;
    }

    private Diary toEntity(DiaryDTO dto) {
        Diary diary = new Diary();
        diary.setId(dto.getId());
        diary.setCreatedAt(dto.getCreatedAt());
        diary.setUpdatedAt(dto.getUpdatedAt());
        diary.setMark(dto.getMark());
        if (dto.getSkillsId() != null) {
            diary.setSkills(commonReferenceRepository.findById(dto.getSkillsId()).orElse(null));
        }
        if (dto.getCategoryId() != null) {
            diary.setCategory(commonReferenceRepository.findById(dto.getCategoryId()).orElse(null));
        }
        if (dto.getUserId() != null) {
            diary.setUser(userRepository.findById(dto.getUserId()).orElse(null));
        }
        return diary;
    }
}
