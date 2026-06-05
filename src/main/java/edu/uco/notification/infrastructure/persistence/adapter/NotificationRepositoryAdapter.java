package edu.uco.notification.infrastructure.persistence.adapter;

import edu.uco.notification.domain.model.Notification;
import edu.uco.notification.domain.repository.NotificationRepository;
import edu.uco.notification.infrastructure.persistence.mapper.NotificationMapper;
import edu.uco.notification.infrastructure.persistence.repository.NotificationJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class NotificationRepositoryAdapter
        implements NotificationRepository {

    private final NotificationJpaRepository repository;

    public NotificationRepositoryAdapter(
            NotificationJpaRepository repository) {

        this.repository = repository;
    }

    @Override
    public Notification save(
            Notification notification) {

        var entity = NotificationMapper.toEntity(notification);

        var saved = repository.save(entity);

        return NotificationMapper.toDomain(saved);
    }

    @Override
    public List<Notification> findByUserId(
            String userId) {

        return repository.findByUserId(userId)
                .stream()
                .map(NotificationMapper::toDomain)
                .toList();
    }

    @Override
    public Notification findById(UUID id) {

        return repository.findById(id)
                .map(NotificationMapper::toDomain)
                .orElse(null);
    }
}