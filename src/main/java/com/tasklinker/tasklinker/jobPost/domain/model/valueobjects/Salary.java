package com.tasklinker.tasklinker.jobPost.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Embeddable
public record Salary(@Min(0) double amount, @NotBlank String currency) {
    public Salary() {
        this(0, "USD");
    }

    public Salary {
        if (amount < 0) {
            throw new IllegalArgumentException("Salary amount cannot be negative.");
        }
        if (!currency.matches("^[A-Z]{3}$")) {
            throw new IllegalArgumentException("Currency must be a valid ISO 4217 code.");
        }
    }
}
