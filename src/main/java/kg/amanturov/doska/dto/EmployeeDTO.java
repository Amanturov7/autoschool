package kg.amanturov.doska.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;
@Data
public class EmployeeDTO {
    private Long id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String name;
    private LocalDate dateOfBirth;
    private String number;
    private String email;
    private String whatsUp;
    private String telegram;
    private String skills;
}
