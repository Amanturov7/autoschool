package kg.amanturov.doska.dto;

import jakarta.persistence.*;
import kg.amanturov.doska.models.Employee;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class LessonsDTO {
    private Long id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String name;
    private Long groupId;
    private Long lessonType;
    private String lessonTypeName;
    private String description;
    private Boolean isArchived;
    private Timestamp timeRemain;
}
