package edu.uco.notification.application.usecase;

import edu.uco.notification.domain.model.Notification;
import edu.uco.notification.domain.repository.NotificationRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetNotificationsByUserUseCaseImpl
        implements GetNotificationsByUserUseCase {

    private final NotificationRepository repository;

    public GetNotificationsByUserUseCaseImpl(
            NotificationRepository repository) {

        this.repository = repository;
    }

    @Override
    public List<Notification> execute(
            String userId) {

        return repository.findByUserId(userId);
    }
}