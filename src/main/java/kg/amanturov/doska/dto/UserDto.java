package kg.amanturov.doska.dto;

import lombok.Data;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

@Data
public class UserDto {
    private Long id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String role;
    private String username;
    private String password;
    private String passportSerial;
    private Timestamp signupDate;
    private BigInteger inn;
    private BigInteger phone;
    private String address;
    private String email;
    private String name;
    private String surname;
    private String lastName;
    private Date dateOfBirth;
    private String telegram;
    private String whatsUp;
    private Boolean agree;
    private Long regionId;
    private Long districtId;
    private Long groupId;
    private Long employeeId;
}


