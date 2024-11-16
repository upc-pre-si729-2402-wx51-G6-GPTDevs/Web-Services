package com.tasklinker.tasklinker.infrastructure.persistence.jpa.repositories;

import com.tasklinker.tasklinker.domain.model.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findAll();
}
