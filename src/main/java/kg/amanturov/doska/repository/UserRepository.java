package kg.amanturov.doska.repository;

import kg.amanturov.doska.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    User findByUsername(String username);
    Boolean existsByUsername(String username);
}
