package com.tasklinker.tasklinker.application.internal.command;

public record SendNotificationCommand(String message, String recipient) {}
