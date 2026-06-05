package edu.uco.notification.domain.repository;

import edu.uco.notification.domain.model.Notification;

import java.util.List;
import java.util.UUID;

public interface NotificationRepository {

    Notification save(Notification notification);

    List<Notification> findByUserId(String userId);

    Notification findById(UUID id);

}