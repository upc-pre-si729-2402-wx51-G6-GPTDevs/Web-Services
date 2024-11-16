package com.tasklinker.tasklinker.Application.internal.command;

import com.tasklinker.tasklinker.domain.model.entities.Notification;
import com.tasklinker.tasklinker.infrastructure.persistence.jpa.repositories.NotificationRepository;
import org.springframework.stereotype.Service;

@Service
public class SendNotificationHandler {
    private final NotificationRepository repository;

    public SendNotificationHandler(NotificationRepository repository) {
        this.repository = repository;
    }

    public void handle(SendNotificationCommand command) {
        Notification notification = new Notification(
                command.message(),
                command.recipient(),
                "TaskLinker Context - Facilitando trabajos por horas en Perú"
        );
        repository.save(notification);
    }
}
