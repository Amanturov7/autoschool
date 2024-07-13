package kg.amanturov.doska.dto;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class ScheduleDTO {
    private Long id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp date;
    private String name;
    private Long groupId;
}
