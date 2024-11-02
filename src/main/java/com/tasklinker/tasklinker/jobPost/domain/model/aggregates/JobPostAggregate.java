package com.tasklinker.tasklinker.jobPost.domain.model.aggregates;

import java.time.LocalDate;

import com.tasklinker.tasklinker.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.tasklinker.tasklinker.jobPost.domain.model.commands.CreateJobPostCommand;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class JobPost extends AuditableAbstractAggregateRoot<JobPost> {

    @NotBlank
    private String title;

    @NotBlank
    @Column(length = 200)
    private String description;

    @NotBlank
    private String contractType;

    @NotBlank
    private String category;

    @NotBlank
    private String location;

    @NotNull
    private LocalDate date;

    @NotNull
    private Double payment;
    private String attachmentUrl;

    public JobPost() {
    }

    public JobPost(String title, String description, String contractType, String category, String location,
                   LocalDate date, Double payment, String attachmentUrl) {
        this.title = title;
        this.description = description;
        this.contractType = contractType;
        this.category = category;
        this.location = location;
        this.date = date;
        this.payment = payment;
        this.attachmentUrl = attachmentUrl;
    }

    public JobPost(CreateJobPostCommand command) {
        this.title = command.getTitle();
        this.description = command.getDescription();
        this.contractType = command.getContractType();
        this.category = command.getCategory();
        this.location = command.getLocation();
        this.date = command.getDate();
        this.payment = command.getPayment();
        this.attachmentUrl = command.getAttachmentUrl();
    }
}

