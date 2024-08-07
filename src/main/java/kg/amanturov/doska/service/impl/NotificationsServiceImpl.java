package kg.amanturov.doska.service.impl;


import kg.amanturov.doska.dto.NotificationsDto;
import kg.amanturov.doska.models.CommonReference;
import kg.amanturov.doska.models.Notifications;
import kg.amanturov.doska.repository.NotificationsRepository;
import kg.amanturov.doska.service.CommonReferenceService;
import kg.amanturov.doska.service.NotificationsService;
import kg.amanturov.doska.service.UserService;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class NotificationsServiceImpl implements NotificationsService {
    private final NotificationsRepository repository;
    private final UserService userService;
    private final CommonReferenceService commonReferenceService;
    public NotificationsServiceImpl(NotificationsRepository repository, UserService userService, CommonReferenceService commonReferenceService) {
        this.repository = repository;
        this.userService = userService;
        this.commonReferenceService = commonReferenceService;
    }

    @Override
    public List<NotificationsDto> findAll() {
        List<Notifications> notificationsList = repository.findAll();

        return notificationsList.stream()
                .map(this::convertNotificationsToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void saveNotifications(NotificationsDto notificationsDto) {
        repository.save(convertDtoToNotifications(notificationsDto));
    }

    @Override
    public List<NotificationsDto> findByNotificationsType(Long id) {
        CommonReference notificationType = commonReferenceService.findById(id);
        List<Notifications> notificationsList = repository.findAllByNotificationType(notificationType);
        return notificationsList.stream()
                .map(this::convertNotificationsToDto)
                .collect(Collectors.toList());
    }



    @Override
    public List<NotificationsDto> findByUserIdAndNotificationTypeId(Long userId, Long typeId) {
        List<Notifications> notificationsList = repository.findByUserIdAndNotificationTypeId(userId, typeId);
        return notificationsList.stream()
                .filter(notification -> !notification.getIsArchived())
                .map(this::convertNotificationsToDto)
                .collect(Collectors.toList());
    }



    @Override
    public List<NotificationsDto> findByUserId(Long id) {
        List<Notifications> notificationsList = repository.findByUserId(id);
        return notificationsList.stream()
                .map(this::convertNotificationsToDto)
                .collect(Collectors.toList());
    }
    @Override
    public void deleteNotifications(Long id) {
        repository.deleteById(id);
    }
    private NotificationsDto  convertNotificationsToDto ( Notifications notifications){
        NotificationsDto notificationsDto = new NotificationsDto();
        notificationsDto.setDescription(notifications.getDescription());
        notificationsDto.setTitle(notifications.getTitle());
        notificationsDto.setId(notifications.getId());
        notificationsDto.setCreatedDate(notifications.getCreatedDate());
        notificationsDto.setUserId(userService.findById(notifications.getUser().getId()).getId());
        notificationsDto.setNotificationTypeId(commonReferenceService.findById(notifications.getNotificationType().getId()).getId());
        notificationsDto.setNotificationName(commonReferenceService.findById(notifications.getNotificationType().getId()).getTitle());
        return notificationsDto;
    }


    private Notifications  convertDtoToNotifications ( NotificationsDto notificationsDto){
        Notifications notifications = new Notifications();
        notifications.setDescription(notificationsDto.getDescription());
        notifications.setTitle(notificationsDto.getTitle());
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        notifications.setCreatedDate(timestamp);
        if(notificationsDto.getUserId() != null){
            notifications.setUser(userService.findById(notificationsDto.getUserId()));
        }
        if(notificationsDto.getNotificationTypeId() != null){
            notifications.setNotificationType(commonReferenceService.findById(notificationsDto.getNotificationTypeId()));
        }
        return notifications;
    }
}
