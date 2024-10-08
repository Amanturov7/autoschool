package kg.amanturov.doska.service.impl;

import kg.amanturov.doska.dto.EmployeeDTO;
import kg.amanturov.doska.models.Employee;
import kg.amanturov.doska.repository.EmployeeRepository;
import kg.amanturov.doska.service.CommonReferenceService;
import kg.amanturov.doska.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final CommonReferenceService commonReferenceService;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository, CommonReferenceService commonReferenceService) {
        this.employeeRepository = employeeRepository;
        this.commonReferenceService = commonReferenceService;
    }

    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        Employee employee = toEntity(employeeDTO);
        employee = employeeRepository.save(employee);
        return toDTO(employee);
    }

    @Override
    public EmployeeDTO update(Long id, EmployeeDTO employeeDTO) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        Employee updatedEmployee = toEntity(employeeDTO);
        updatedEmployee.setId(existingEmployee.getId());
        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
        updatedEmployee.setCreatedAt(existingEmployee.getCreatedAt());
        updatedEmployee.setUpdatedAt(timestamp);
        updatedEmployee = employeeRepository.save(updatedEmployee);
        return toDTO(updatedEmployee);
    }

    @Override
    public void delete(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        employeeRepository.delete(employee);
    }

    @Override
    public EmployeeDTO findById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        return toDTO(employee);
    }

    @Override
    public Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));

    }

    @Override
    public List<EmployeeDTO> findAll() {
        return employeeRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private EmployeeDTO toDTO(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setCreatedAt(employee.getCreatedAt());
        dto.setUpdatedAt(employee.getUpdatedAt());
        dto.setName(employee.getName());
        dto.setDateOfBirth(employee.getDateOfBirth());
        dto.setNumber(employee.getNumber());
        dto.setEmail(employee.getEmail());
        dto.setWhatsUp(employee.getWhatsUp());
        dto.setTelegram(employee.getTelegram());
        dto.setSkills(employee.getSkills());
        dto.setEmployeeTypeId(employee.getEmployeeType().getId());
        dto.setEmployeeTypeName(employee.getEmployeeType().getTitle());
        return dto;
    }

    private Employee toEntity(EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setId(dto.getId());
        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
        employee.setCreatedAt(timestamp);
        employee.setUpdatedAt(dto.getUpdatedAt());
        employee.setName(dto.getName());
        employee.setDateOfBirth(dto.getDateOfBirth());
        employee.setNumber(dto.getNumber());
        employee.setEmail(dto.getEmail());
        employee.setWhatsUp(dto.getWhatsUp());
        employee.setTelegram(dto.getTelegram());
        employee.setSkills(dto.getSkills());
        if(Objects.nonNull(dto.getEmployeeTypeId())){
            employee.setEmployeeType(commonReferenceService.findById(dto.getEmployeeTypeId()));
        }
        return employee;
    }
}
