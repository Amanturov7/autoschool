package kg.amanturov.doska.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Table(name = "employee")
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_type")
    private CommonReference employeeType;
}
