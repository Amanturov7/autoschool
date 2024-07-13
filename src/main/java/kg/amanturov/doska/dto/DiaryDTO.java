package kg.amanturov.doska.dto;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class DiaryDTO {
    private Long id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Long skillsId;
    private Integer mark;
    private Long categoryId;
    private Long userId;
}
