package com.example.webservicenotificationsbc;

import com.example.webservicenotificationsbc.Application.internal.command.SendNotificationCommand;
import com.example.webservicenotificationsbc.Application.internal.command.SendNotificationHandler;
import com.example.webservicenotificationsbc.domain.model.entities.Notification;
import com.example.webservicenotificationsbc.infrastructure.persistence.jpa.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class NotificationServiceTest {

    @Autowired
    private NotificationRepository repository;

    @Autowired
    private SendNotificationHandler handler;

    @Test
    public void shouldSendNotification() {
        handler.handle(new SendNotificationCommand("Hello", "user@example.com"));

        Notification notification = repository.findAll().getFirst();

        assertEquals("Hello", notification.getMessage());
        assertEquals("user@example.com", notification.getRecipient());
        assertEquals("TaskLinker Context - Facilitando trabajos por horas en Perú", notification.getContext());
    }
}
