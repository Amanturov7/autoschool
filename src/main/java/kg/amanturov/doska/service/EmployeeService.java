package kg.amanturov.doska.service;

import kg.amanturov.doska.dto.EmployeeDTO;
import kg.amanturov.doska.models.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO save(EmployeeDTO employeeDTO);
    EmployeeDTO update(Long id, EmployeeDTO employeeDTO);
    void delete(Long id);
    EmployeeDTO findById(Long id);

    Employee findEmployeeById(Long id);

    List<EmployeeDTO> findAll();

}
