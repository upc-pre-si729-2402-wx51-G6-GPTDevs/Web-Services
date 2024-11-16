package com.tasklinker.tasklinker.interfaces.rest.acl;

import java.util.List;

public interface NotificationContextFacade {
    void sendNotification(String message, String recipient);
    List<?> fetchNotifications();
}
