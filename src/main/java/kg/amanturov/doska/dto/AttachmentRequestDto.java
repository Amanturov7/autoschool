package kg.amanturov.doska.dto;


import lombok.Data;

@Data
public class AttachmentRequestDto {
    private String type;
    private String originName;
    private String description;
    private Long userProfileId;
    private Long groupsId;
    private Long ticketsId;
    private Long carsId;
}
