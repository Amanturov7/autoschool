package kg.amanturov.doska.repository;

import kg.amanturov.doska.models.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupsRepository extends JpaRepository<Groups,Long> {
}
