package com.tasklinker.tasklinker.jobPost.domain.model.commands;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdateJobPostCommand {

    @NotNull
    private final Long jobPostId;

    @NotBlank
    private final String title;

    @NotBlank
    private final String description;

    @NotBlank
    private final String contractType;

    @NotBlank
    private final String category;

    @NotBlank
    private final String location;

    @NotNull
    private final LocalDate date;

    @NotNull
    private final BigDecimal payment;

    private final String fileAttachment;

    public UpdateJobPostCommand(Long jobPostId, String title, String description, String contractType,
                                String category, String location, LocalDate date,
                                BigDecimal payment, String fileAttachment) {
        this.jobPostId = jobPostId;
        this.title = title;
        this.description = description;
        this.contractType = contractType;
        this.category = category;
        this.location = location;
        this.date = date;
        this.payment = payment;
        this.fileAttachment = fileAttachment;
    }


    public Long getJobPostId() {
        return jobPostId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getContractType() {
        return contractType;
    }

    public String getCategory() {
        return category;
    }

    public String getLocation() {
        return location;
    }

    public LocalDate getDate() {
        return date;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public String getFileAttachment() {
        return fileAttachment;
    }
}
