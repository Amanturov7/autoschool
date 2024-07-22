package kg.amanturov.doska.service;

import kg.amanturov.doska.RestResponse;
import kg.amanturov.doska.dto.LessonsDTO;

import java.util.List;

public interface LessonsService {
    RestResponse save(LessonsDTO lessonsDTO);

    RestResponse update(Long id, LessonsDTO lessonsDTO);

    void delete(Long id);

    RestResponse findById(Long id);

    RestResponse findAllByGroupsId(Long id);

    RestResponse findAllByLessonTypeAndGroupsId(Long typeId, Long groupId);

    RestResponse findAll();
}
