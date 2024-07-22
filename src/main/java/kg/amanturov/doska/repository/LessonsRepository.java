package kg.amanturov.doska.repository;

import kg.amanturov.doska.models.Lessons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonsRepository extends JpaRepository<Lessons,Long> {
}
