package kg.amanturov.doska.dto;

import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Data
public class UserDetailsDto {
    private BigInteger phone;
    private String address;
    private String email;
    private String name;
    private String surname;
    private String lastName;
    private Date dateOfBirth;
    private String telegram;
    private String whatsUp;
    private String groupName;
    private Long groupId;
}
