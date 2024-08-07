package kg.amanturov.doska.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class GroupsDTO {
    private Long id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String name;
    private Long typeStudyId;
    private Long categoryId;
    private String typeStudyName;
    private String categoryName;
    private Long employeeId;
    private String employeeName;
    private List<UserDetailsDto> usersDto;
}
