package edu.uco.notification.infrastructure.persistence.mapper;

import edu.uco.notification.domain.model.Notification;
import edu.uco.notification.infrastructure.persistence.entity.NotificationEntity;

public class NotificationMapper {

    public static NotificationEntity toEntity(
            Notification notification) {

        NotificationEntity entity =
                new NotificationEntity();

        entity.setId(notification.getId());
        entity.setUserId(notification.getUserId());
        entity.setRecipient(notification.getRecipient());
        entity.setMessage(notification.getMessage());
        entity.setType(notification.getType());
        entity.setStatus(notification.getStatus());
        entity.setCreatedAt(notification.getCreatedAt());

        return entity;
    }

    public static Notification toDomain(
            NotificationEntity entity) {

        Notification notification =
                new Notification();

        notification.setId(entity.getId());
        notification.setUserId(entity.getUserId());
        notification.setRecipient(entity.getRecipient());
        notification.setMessage(entity.getMessage());
        notification.setType(entity.getType());
        notification.setStatus(entity.getStatus());
        notification.setCreatedAt(entity.getCreatedAt());

        return notification;
    }
}