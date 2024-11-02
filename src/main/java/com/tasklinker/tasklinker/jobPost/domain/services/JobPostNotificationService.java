package com.tasklinker.jobPost.domain.services;

public interface NotificationService {

    void sendJobPostCreatedNotification(Long jobId);
    void sendJobPostUpdatedNotification(Long jobId);
    void sendJobPostDeletedNotification(Long jobId);
}
