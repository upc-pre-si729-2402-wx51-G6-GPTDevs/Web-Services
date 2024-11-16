package com.tasklinker.tasklinker.domain.services;

import com.tasklinker.tasklinker.Application.internal.command.SendNotificationCommand;

public interface NotificationCommandService {
    void handle(SendNotificationCommand command);
}
