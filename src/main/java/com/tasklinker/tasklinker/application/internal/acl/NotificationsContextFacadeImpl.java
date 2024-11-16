package com.tasklinker.tasklinker.application.internal.acl;

import com.tasklinker.tasklinker.domain.model.entities.Notification;
import org.springframework.stereotype.Service;
import com.tasklinker.tasklinker.application.internal.command.SendNotificationCommand;
import com.tasklinker.tasklinker.application.internal.query.GetNotificationsQuery;
import com.tasklinker.tasklinker.application.internal.command.SendNotificationHandler;
import com.tasklinker.tasklinker.application.internal.query.GetNotificationsHandler;
import com.tasklinker.tasklinker.interfaces.rest.acl.NotificationContextFacade;

import java.util.List;

@Service
public class NotificationsContextFacadeImpl implements NotificationContextFacade {

    private final SendNotificationHandler sendNotificationHandler;
    private final GetNotificationsHandler getNotificationsHandler;

    public NotificationsContextFacadeImpl(SendNotificationHandler sendNotificationHandler,
                                          GetNotificationsHandler getNotificationsHandler) {
        this.sendNotificationHandler = sendNotificationHandler;
        this.getNotificationsHandler = getNotificationsHandler;
    }

    @Override
    public void sendNotification(String message, String recipient) {
        var command = new SendNotificationCommand(message, recipient);
        sendNotificationHandler.handle(command);
    }

    @Override
    public List<Notification> fetchNotifications() {
        return getNotificationsHandler.handle(new GetNotificationsQuery());
    }
}
