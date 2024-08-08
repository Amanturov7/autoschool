package kg.amanturov.doska.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import kg.amanturov.doska.Exceptions.UserNotFoundException;
import kg.amanturov.doska.dto.UserDto;
import kg.amanturov.doska.dto.UserDetailsDto;
import kg.amanturov.doska.models.RefreshToken;
import kg.amanturov.doska.models.User;
import kg.amanturov.doska.repository.EmployeeRepository;
import kg.amanturov.doska.repository.GroupsRepository;
import kg.amanturov.doska.repository.RefreshTokenRepository;
import kg.amanturov.doska.repository.UserRepository;
import kg.amanturov.doska.security.TokenProvider;
import kg.amanturov.doska.service.CommonReferenceService;
import kg.amanturov.doska.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @PersistenceContext
    private EntityManager entityManager;

    private final UserRepository userRepository;
    private final TokenProvider tokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;
    private final CommonReferenceService commonReferenceService;
    private final GroupsRepository groupsRepository;
    private final EmployeeRepository employeeRepository;


    private static final Logger log = LogManager.getLogger(UserServiceImpl.class);
    public UserServiceImpl(UserRepository userRepository, TokenProvider tokenProvider, RefreshTokenRepository refreshTokenRepository, CommonReferenceService commonReferenceService, GroupsRepository groupsRepository, EmployeeRepository employeeRepository) {
        this.userRepository = userRepository;
        this.tokenProvider = tokenProvider;
        this.refreshTokenRepository = refreshTokenRepository;
        this.commonReferenceService = commonReferenceService;
        this.groupsRepository = groupsRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<UserDetailsDto> getAllUsers() {
       return userRepository.findAll().stream()
               .map(this::toUserGroupDto)
               .collect(Collectors.toList());
    }

//    @Override
//    public List<UserDetailsDto> findAllEmployees() {
//        return userRepository.findAllEmployee().stream()
//                .map(this::toUserGroupDto)
//                .collect(Collectors.toList());
//    }



    @Override
    public Optional<User> getUserByUsername(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username));
    }

    @Override
    public Optional<User> getUserByToken(String token) {
        return refreshTokenRepository.findByToken(token).map(RefreshToken::getUserInfo);
    }



    @Override
    public boolean hasUserWithUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean hasUserWithEmail(String email) {
        return false;
    }

    @Override
    public User validateAndGetUserByUsername(String username) {
        return getUserByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with username %s not found", username)));
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }


    @Override
    public List<UserDetailsDto> findAllByGroupId(Long id) {
        return userRepository.findAllByGroupId(id)
                .stream()
                .map(this::toUserGroupDto)
                .collect(Collectors.toList());
    }


    public UserDetailsDto toUserGroupDto(User user) {
        if (user == null) {
            return null;
        }
        UserDetailsDto dto = new UserDetailsDto();
        dto.setPhone(user.getPhone());
        dto.setAddress(user.getAddress());
        dto.setEmail(user.getEmail());
        dto.setName(user.getName());
        dto.setSurname(user.getSurname());
        dto.setLastName(user.getLastName());
        dto.setDateOfBirth(user.getDateOfBirth());
        dto.setTelegram(user.getTelegram());
        dto.setFio(user.getName()+" "+user.getSurname());
        dto.setWhatsUp(user.getWhatsUp());
        if(Objects.nonNull(user.getGroup())){
            dto.setGroupId(user.getGroup().getId());
            dto.setGroupName(user.getGroup().getName());
        }
        return dto;
    }

    public User userDtoToEntity(UserDto dto) {
        if (dto == null) {
            return null;
        }

        User user = new User();
        user.setId(dto.getId());
        user.setCreatedAt(dto.getCreatedAt());
        user.setUpdatedAt(dto.getUpdatedAt());
        user.setRole(dto.getRole());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setPassportSerial(dto.getPassportSerial());
        user.setSignupDate(dto.getSignupDate());
        user.setInn(dto.getInn());
        user.setPhone(dto.getPhone());
        user.setAddress(dto.getAddress());
        user.setEmail(dto.getEmail());
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setLastName(dto.getLastName());
        user.setDateOfBirth(dto.getDateOfBirth());
        user.setTelegram(dto.getTelegram());
        user.setWhatsUp(dto.getWhatsUp());
        user.setAgree(dto.getAgree());

        if(Objects.nonNull(dto.getRegionId())){
            user.setRegion(commonReferenceService.findById(dto.getRegionId()));
        }
        if(Objects.nonNull(dto.getDistrictId())){
            user.setRegion(commonReferenceService.findById(dto.getDistrictId()));
        }
        if(Objects.nonNull(dto.getEmployeeId())){
            user.setEmployee(employeeRepository.findById(dto.getEmployeeId()).orElse(null));
        }
        if(Objects.nonNull(dto.getGroupId())){
            user.setGroup(groupsRepository.findById(dto.getGroupId()).orElse(null));
        }

        return user;
    }


    public User userDetailsDtoToEntity(UserDto dto) {
        if (dto == null) {
            return null;
        }

        User user = new User();
        user.setId(dto.getId());
        user.setCreatedAt(dto.getCreatedAt());
        user.setUpdatedAt(dto.getUpdatedAt());
        user.setRole(dto.getRole());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setPassportSerial(dto.getPassportSerial());
        user.setSignupDate(dto.getSignupDate());
        user.setInn(dto.getInn());
        user.setPhone(dto.getPhone());
        user.setAddress(dto.getAddress());
        user.setEmail(dto.getEmail());
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setLastName(dto.getLastName());
        user.setDateOfBirth(dto.getDateOfBirth());
        user.setTelegram(dto.getTelegram());
        user.setWhatsUp(dto.getWhatsUp());
        user.setAgree(dto.getAgree());

        if(Objects.nonNull(dto.getRegionId())){
            user.setRegion(commonReferenceService.findById(dto.getRegionId()));
        }
        if(Objects.nonNull(dto.getDistrictId())){
            user.setRegion(commonReferenceService.findById(dto.getDistrictId()));
        }
        if(Objects.nonNull(dto.getEmployeeId())){
            user.setEmployee(employeeRepository.findById(dto.getEmployeeId()).orElse(null));
        }
        if(Objects.nonNull(dto.getGroupId())){
            user.setGroup(groupsRepository.findById(dto.getGroupId()).orElse(null));
        }

        return user;
    }
    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
