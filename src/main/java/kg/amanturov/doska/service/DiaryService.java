package kg.amanturov.doska.service;

import kg.amanturov.doska.dto.DiaryDTO;

import java.util.List;

public interface DiaryService {
    DiaryDTO save(DiaryDTO diaryDTO);
    DiaryDTO update(Long id, DiaryDTO diaryDTO);
    void delete(Long id);
    DiaryDTO findById(Long id);
    List<DiaryDTO> findAll();
}
