package kg.amanturov.doska.dto.securityDto;


import kg.amanturov.doska.models.User;
import kg.amanturov.doska.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtToken {

    private String token;
    private UserService userService;

    public Optional<User> getUser() {

        return userService.getUserByToken(token);
    }
}
