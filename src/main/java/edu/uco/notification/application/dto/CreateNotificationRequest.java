package edu.uco.notification.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateNotificationRequest {

    private String userId;

    private String recipient;

    private String message;
}