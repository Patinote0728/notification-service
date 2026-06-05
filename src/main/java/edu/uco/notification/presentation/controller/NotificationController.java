package edu.uco.notification.presentation.controller;

import edu.uco.notification.application.dto.CreateNotificationRequest;
import edu.uco.notification.application.usecase.SendNotificationUseCase;
import edu.uco.notification.application.usecase.GetNotificationsByUserUseCase;
import edu.uco.notification.domain.model.Notification;
import edu.uco.notification.domain.model.NotificationStatus;
import edu.uco.notification.domain.model.NotificationType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {

    private final SendNotificationUseCase useCase;
    private final GetNotificationsByUserUseCase getNotificationsByUserUseCase;

    public NotificationController(
            SendNotificationUseCase useCase,
            GetNotificationsByUserUseCase getNotificationsByUserUseCase) {

        this.useCase = useCase;
        this.getNotificationsByUserUseCase = getNotificationsByUserUseCase;
    }

    @PostMapping
    public ResponseEntity<Notification> create(
            @RequestBody CreateNotificationRequest request) {

        Notification notification = new Notification();
        notification.setId(UUID.randomUUID());
        notification.setUserId(request.getUserId());
        notification.setRecipient(request.getRecipient());
        notification.setMessage(request.getMessage());
        notification.setType(NotificationType.PURCHASE_CONFIRMED);
        notification.setStatus(NotificationStatus.PENDING);
        notification.setCreatedAt(LocalDateTime.now());

        Notification saved = useCase.execute(notification);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Notification>> findByUser(
            @PathVariable String userId) {

        return ResponseEntity.ok(
                getNotificationsByUserUseCase.execute(userId));
    }
}
