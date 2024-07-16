package kg.amanturov.doska.service;


import kg.amanturov.doska.dto.EmployeeSIgnUpDto;
import kg.amanturov.doska.dto.securityDto.LoginResponse;

public interface SignUpService {

    void saveEmployee(EmployeeSIgnUpDto dtos);

    LoginResponse findByUserName(String userName);
}
