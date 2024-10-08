package kg.amanturov.doska.service.impl;



import kg.amanturov.doska.Exceptions.DuplicatedUserInfoException;
import kg.amanturov.doska.dto.EmployeeSIgnUpDto;
import kg.amanturov.doska.dto.securityDto.LoginResponse;
import kg.amanturov.doska.models.User;
import kg.amanturov.doska.security.WebSecurityConfig;
import kg.amanturov.doska.service.EmployeeService;
import kg.amanturov.doska.service.GroupsService;
import kg.amanturov.doska.service.SignUpService;
import kg.amanturov.doska.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class SignUpServiceImpl implements SignUpService {

    private final UserService userService;
    private final EmployeeService employeeService;
    private final GroupsService groupsService;
    private final PasswordEncoder passwordEncoder;

    public SignUpServiceImpl(UserService userService, EmployeeService employeeService, GroupsService groupsService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.employeeService = employeeService;
        this.groupsService = groupsService;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void saveEmployee(EmployeeSIgnUpDto dtos) {
            try {
                validateEmployeeDto(dtos);
                userService.saveUser(mapSignUpRequestToUser(dtos));
            } catch (DuplicatedUserInfoException e) {
                throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
            }
    }



    @Override
    public LoginResponse findByUserName(String userName) {
        LoginResponse loginResponse = new LoginResponse();
        User user = userService.getUserByUsername(userName).get();
        loginResponse.setUserName(user.getUsername());
        return loginResponse;
    }

    private void validateEmployeeDto(EmployeeSIgnUpDto dto) {
        if (userService.hasUserWithUsername(dto.getLogin())) {
            throw new DuplicatedUserInfoException("Логин уже занят: " + dto.getLogin());
        }
        if (userService.hasUserWithEmail(dto.getEmail())) {
            throw new DuplicatedUserInfoException("Почта уже занята: " + dto.getEmail());
        }
    }
    private User mapSignUpRequestToUser(EmployeeSIgnUpDto signUpRequest) {
        User user = new User();
        user.setUsername(signUpRequest.getLogin());
        user.setInn(signUpRequest.getInn());
        user.setAddress(signUpRequest.getAddress());
        user.setPhone(signUpRequest.getPhone());
        user.setEmail(signUpRequest.getEmail());
        user.setPassportSerial(signUpRequest.getPassportSerial());
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        user.setSignupDate(timestamp);
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        user.setRole(WebSecurityConfig.USER);
        user.setCreatedAt(timestamp);
        user.setUpdatedAt(timestamp);
        if(signUpRequest.getEmployeeId() != null) {
            user.setEmployee(employeeService.findEmployeeById(signUpRequest.getEmployeeId()));

        }
        if(signUpRequest.getGroupId() != null) {
            user.setGroup(groupsService.findGroupById(signUpRequest.getGroupId()));
        }
        user.setSignupDate(timestamp);
        user.setName(signUpRequest.getName());
        user.setSurname(signUpRequest.getSurname());
        user.setLastName(signUpRequest.getLastName());
        user.setDateOfBirth(signUpRequest.getDateOfBirth());
        user.setTelegram(signUpRequest.getTelegram());
        user.setWhatsUp(signUpRequest.getWhatsUp());
        user.setAgree(signUpRequest.getAgree());
        return user;
    }
}


