package kg.amanturov.doska.repository;


import kg.amanturov.doska.models.CommonReference;
import kg.amanturov.doska.models.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface NotificationsRepository  extends JpaRepository<Notifications, Long> {
    List<Notifications> findAllByNotificationType(CommonReference notificationType);
List<Notifications>   findByUserIdAndNotificationTypeId (Long userId, Long typeId);
List<Notifications>   findByUserId (Long id);
}
