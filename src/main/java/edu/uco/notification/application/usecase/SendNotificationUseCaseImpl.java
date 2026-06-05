package edu.uco.notification.application.usecase;

import edu.uco.notification.domain.model.Notification;
import edu.uco.notification.domain.repository.NotificationRepository;

import org.springframework.stereotype.Service;

@Service
public class SendNotificationUseCaseImpl
        implements SendNotificationUseCase {

    private final NotificationRepository repository;

    public SendNotificationUseCaseImpl(
            NotificationRepository repository) {

        this.repository = repository;
    }

    @Override
    public Notification execute(
            Notification notification) {

        return repository.save(notification);
    }
}