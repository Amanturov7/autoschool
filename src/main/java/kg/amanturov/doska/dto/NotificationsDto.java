package kg.amanturov.doska.dto;
import lombok.Data;

import java.sql.Timestamp;
@Data
public class NotificationsDto {

    private Long id;
    private Long notificationTypeId;
    private String notificationName;
    private String description;
    private String title;
    private Timestamp createdDate;
    private Long userId;
}
