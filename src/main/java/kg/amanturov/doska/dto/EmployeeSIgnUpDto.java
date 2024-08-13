package kg.amanturov.doska.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

@Data
public class EmployeeSIgnUpDto {

    @NotBlank(message = "Login cannot be blank")
    private String login;
    @NotBlank(message = "Password cannot be blank")
    @Size(min = 6, message = "Password must be at least 8 characters")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z]).*$", message = "Password must contain at least one letter and one digit")
    private String password;
    private BigInteger phone;
    private String address;
    private BigInteger inn;
    private String passportSerial;
    private String email;
    private Timestamp signupDate;
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
