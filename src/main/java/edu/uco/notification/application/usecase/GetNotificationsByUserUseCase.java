package edu.uco.notification.application.usecase;

import edu.uco.notification.domain.model.Notification;

import java.util.List;

public interface GetNotificationsByUserUseCase {

    List<Notification> execute(String userId);

}