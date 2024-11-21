package com.tasklinker.tasklinker.jobPost.domain.services;

public interface JobPostNotificationService {

    void sendJobPostCreatedNotification(Long jobId);

    void sendJobPostUpdatedNotification(Long jobId);

    void sendJobPostDeletedNotification(Long jobId);
}
