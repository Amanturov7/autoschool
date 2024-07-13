package kg.amanturov.doska.dto;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class CertificateDTO {
    private Long id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String name;
    private Long userId;
}
