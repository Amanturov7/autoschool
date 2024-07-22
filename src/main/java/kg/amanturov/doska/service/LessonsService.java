package kg.amanturov.doska.service;

import kg.amanturov.doska.dto.LessonsDTO;

import java.util.List;

public interface LessonsService {
    LessonsDTO save(LessonsDTO lessonsDTO);

    LessonsDTO update(Long id, LessonsDTO lessonsDTO);

    void delete(Long id);

    LessonsDTO findById(Long id);

    List<LessonsDTO> findAll();
}
