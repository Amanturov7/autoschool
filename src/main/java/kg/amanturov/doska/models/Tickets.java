package kg.amanturov.doska.models;


import jakarta.persistence.*;

import lombok.Data;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "tickets")
public class Tickets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;
    private String correctAnswer;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Integer ticketNumber;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    public Tickets() {
    }


}
