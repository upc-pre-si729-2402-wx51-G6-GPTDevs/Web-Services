package com.tasklinker.tasklinker.Application.internal.query;

import com.tasklinker.tasklinker.domain.model.entities.Notification;
import com.tasklinker.tasklinker.infrastructure.persistence.jpa.repositories.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetNotificationsHandler {
    private final NotificationRepository repository;

    public GetNotificationsHandler(NotificationRepository repository) {
        this.repository = repository;
    }

    public List<Notification> handle(GetNotificationsQuery query) {
        return repository.findAll();
    }
}
