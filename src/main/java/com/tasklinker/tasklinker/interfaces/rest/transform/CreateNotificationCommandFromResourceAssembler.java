package com.tasklinker.tasklinker.interfaces.rest.transform;

import com.tasklinker.tasklinker.Application.internal.command.SendNotificationCommand;
import com.tasklinker.tasklinker.interfaces.rest.resources.CreateNotificationResource;

public class CreateNotificationCommandFromResourceAssembler {
    public static SendNotificationCommand toCommandFromResource(CreateNotificationResource resource) {
        return new SendNotificationCommand(resource.message(), resource.recipient());
    }
}
