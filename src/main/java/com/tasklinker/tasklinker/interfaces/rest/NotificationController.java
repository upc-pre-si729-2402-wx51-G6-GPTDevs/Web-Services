package com.tasklinker.tasklinker.interfaces.rest;

import com.tasklinker.tasklinker.application.internal.query.GetNotificationsQuery;
import com.tasklinker.tasklinker.application.internal.query.GetNotificationsHandler;
import com.tasklinker.tasklinker.application.internal.command.SendNotificationCommand;
import com.tasklinker.tasklinker.application.internal.command.SendNotificationHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    private final SendNotificationHandler sendNotificationHandler;
    private final GetNotificationsHandler getNotificationsHandler;

    public NotificationController(SendNotificationHandler sendNotificationHandler,
                                  GetNotificationsHandler getNotificationsHandler) {
        this.sendNotificationHandler = sendNotificationHandler;
        this.getNotificationsHandler = getNotificationsHandler;
    }

    @PostMapping
    public void sendNotification(@RequestBody SendNotificationCommand command) {
        sendNotificationHandler.handle(command);
    }

    @GetMapping
    public List<?> getNotifications() {
        return getNotificationsHandler.handle(new GetNotificationsQuery());
    }
}
