package kg.amanturov.doska.service;

import kg.amanturov.doska.dto.NotificationsDto;

import java.util.List;

public interface NotificationsService {

    List<NotificationsDto> findAll();

    void saveNotifications(NotificationsDto notificationsDto);

    List<NotificationsDto> findByNotificationsType(Long id);

    List<NotificationsDto> findByUserIdAndNotificationTypeId(Long userId, Long typeId);

    List<NotificationsDto> findByUserId(Long id);
    void deleteNotifications (Long id);
}
