package kg.amanturov.doska.dto.securityDto;

import lombok.Data;

@Data
public class LoginRequest {
    private String login;
    private String password;
}
