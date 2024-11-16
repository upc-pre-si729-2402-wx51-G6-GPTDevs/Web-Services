package com.tasklinker.tasklinker.domain.services;

import com.tasklinker.tasklinker.application.internal.command.SendNotificationCommand;

public interface NotificationCommandService {
    void handle(SendNotificationCommand command);
}
