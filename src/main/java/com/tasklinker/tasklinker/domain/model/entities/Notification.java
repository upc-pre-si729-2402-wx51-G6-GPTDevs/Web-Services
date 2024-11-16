package com.tasklinker.tasklinker.domain.model.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private String recipient;

    @Column(nullable = false)
    private LocalDateTime sentAt;

    @Column(nullable = false)
    private String context;

    public Notification(String message, String recipient, String context) {
        if (message == null || recipient == null || context == null) {
            throw new IllegalArgumentException("Fields cannot be null");
        }
        this.message = message;
        this.recipient = recipient;
        this.context = context;
        this.sentAt = LocalDateTime.now();
    }

    public Notification() {}

    public Long getId() { return id; }

    public String getMessage() { return message; }

    public String getRecipient() { return recipient; }

    public LocalDateTime getSentAt() { return sentAt; }

    public String getContext() { return context; }
}
