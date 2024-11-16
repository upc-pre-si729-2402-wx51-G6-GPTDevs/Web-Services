package com.tasklinker.tasklinker.domain.services;

import com.tasklinker.tasklinker.application.internal.query.GetNotificationsQuery;
import com.tasklinker.tasklinker.domain.model.entities.Notification;

import java.util.List;

public interface NotificationQueryService {
    List<Notification> handle(GetNotificationsQuery query);
}
