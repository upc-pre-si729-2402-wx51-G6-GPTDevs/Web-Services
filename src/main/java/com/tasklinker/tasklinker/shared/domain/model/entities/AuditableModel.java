package com.tasklinker.tasklinker.shared.domain.model.entities;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;
import lombok.Getter;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class AuditableModel {
    @Getter
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date creeatedAt;

    @Getter
    @LastModifiedDate
    @Column(nullable = false)
    private Date updatedAt;
}
