package com.tasklinker.tasklinker.interfaces.rest.resources;

public record NotificationResource(Long id, String message, String recipient, String sentAt) {}
