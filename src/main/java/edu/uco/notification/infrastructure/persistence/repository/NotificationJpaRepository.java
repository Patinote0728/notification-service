package edu.uco.notification.infrastructure.persistence.repository;

import edu.uco.notification.infrastructure.persistence.entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface NotificationJpaRepository
        extends JpaRepository<NotificationEntity, UUID> {

    List<NotificationEntity> findByUserId(String userId);

}