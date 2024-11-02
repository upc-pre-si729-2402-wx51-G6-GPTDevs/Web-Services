package com.tasklinker.tasklinker.service;

import com.tasklinker.tasklinker.model.Notification;
import com.tasklinker.tasklinker.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Notification sendNotification(String email, String message) {
        Notification notification = new Notification();
        notification.setRecipientEmail(email);
        notification.setMessage(message);
        notification.setSentAt(LocalDateTime.now());
        return notificationRepository.save(notification);
    }
}
