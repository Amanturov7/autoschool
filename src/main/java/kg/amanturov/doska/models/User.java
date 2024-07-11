package kg.amanturov.doska.models;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    @JoinColumn(name = "type_study_id")
    private CommonReference type_study;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CommonReference category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Groups group;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

}