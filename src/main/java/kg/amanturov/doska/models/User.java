package kg.amanturov.doska.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private CommonReference region;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id")
    private CommonReference district;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Groups group;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;
}