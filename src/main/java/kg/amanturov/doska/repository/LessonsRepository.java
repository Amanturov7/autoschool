package kg.amanturov.doska.repository;

import kg.amanturov.doska.models.CommonReference;
import kg.amanturov.doska.models.Lessons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonsRepository extends JpaRepository<Lessons,Long> {
    List<Lessons> findAllByGroupsId (Long id);
    List<Lessons> findAllByLessonTypeAndGroupsId (CommonReference typeId, Long groupId);
}
