package kg.amanturov.doska.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class JournalDTO {
    private Long id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String name;
}