package com.tasklinker.tasklinker.jobPost.domain.model.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String title;

    @NotBlank
    @Size(max = 500)
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
    @Column(precision = 10, scale = 2)
    private BigDecimal payment;

    private String fileAttachment;

    public JobPost() {
    }

    public JobPost(String title, String description, String contractType, String category,
                   String location, LocalDate date, BigDecimal payment, String fileAttachment) {
        this.title = title;
        this.description = description;
        this.contractType = contractType;
        this.category = category;
        this.location = location;
        this.date = date;
        this.payment = payment;
        this.fileAttachment = fileAttachment;
    }
}
