package kg.amanturov.doska.repository;

import kg.amanturov.doska.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmloyeeRepository extends JpaRepository<Employee,Long> {
}
