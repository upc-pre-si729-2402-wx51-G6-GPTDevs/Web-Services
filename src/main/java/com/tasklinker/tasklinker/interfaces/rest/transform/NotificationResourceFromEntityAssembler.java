package com.tasklinker.tasklinker.interfaces.rest.transform;

import com.tasklinker.tasklinker.domain.model.entities.Notification;
import com.tasklinker.tasklinker.interfaces.rest.resources.NotificationResource;

public class NotificationResourceFromEntityAssembler {
    public static NotificationResource toResourceFromEntity(Notification entity) {
        return new NotificationResource(
                entity.getId(),
                entity.getMessage(),
                entity.getRecipient(),
                entity.getSentAt().toString()
        );
    }
}
