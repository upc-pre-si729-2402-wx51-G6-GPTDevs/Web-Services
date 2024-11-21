package com.tasklinker.tasklinker.controller;

import com.tasklinker.tasklinker.model.Notification;
import com.tasklinker.tasklinker.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    public List<Notification> getAllNotifications() {
        return notificationService.getAllNotifications();
    }

    @PostMapping
    public Notification sendNotification(@RequestParam String email, @RequestParam String message) {
        return notificationService.sendNotification(email, message);
    }
}