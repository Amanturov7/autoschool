package kg.amanturov.doska.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Table(name = "cars")
@Getter
@Setter
public class Cars extends BaseModel{

    private String name;
    private String model;
    private String color;
    private Float engine;
    private Integer year;
    private Integer difficultyLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
