package edu.uco.notification.application.usecase;

import edu.uco.notification.domain.model.Notification;

public interface SendNotificationUseCase {

    Notification execute(Notification notification);

}