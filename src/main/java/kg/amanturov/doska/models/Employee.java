package kg.amanturov.doska.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Table(name = "diary")
@Getter
@Setter
public class Employee extends BaseModel{

    private String name;
    private LocalDate dateOfBirth;
    private String number;
    private String email;
    private String whatsUp;
    private String telegram;
    private String skills;
}
