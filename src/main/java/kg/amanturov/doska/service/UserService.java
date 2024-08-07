package kg.amanturov.doska.service;




import kg.amanturov.doska.dto.UserDetailsDto;
import kg.amanturov.doska.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {


    List<User> getUsers();

    List<UserDetailsDto> getAllUsers();

//    List<UserDetailsDto> findAllEmployees();

    Optional<User> getUserByUsername(String username);

    Optional<User> getUserByToken(String token);

    boolean hasUserWithUsername(String username);

    boolean hasUserWithEmail(String email);


    User validateAndGetUserByUsername(String username);

    User saveUser(User user);

    User findById(Long id);

    List<UserDetailsDto> findAllByGroupId(Long id);

    void deleteUser(User user);
}