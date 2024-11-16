package com.tasklinker.tasklinker.domain.model.aggregates;

import com.tasklinker.tasklinker.domain.model.entities.Notification;

import java.util.ArrayList;
import java.util.List;

public class NotificationAggregate {
    private final List<Notification> notifications = new ArrayList<>();

    public void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public int countNotifications() {
        return notifications.size();
    }
}
