package kg.amanturov.doska.dto;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class CarsDTO {
    private Long id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String name;
    private String model;
    private String color;
    private Float engine;
    private Integer year;
    private Integer difficultyLevel;
    private Long employeeId;
}
