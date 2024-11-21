package com.tasklinker.tasklinker.jobPost.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;

@Embeddable
public record JobCategory(@NotBlank String category) {
    public JobCategory() {
        this(null);
    }

    public JobCategory {
        if (category == null || category.isBlank()) {
            throw new IllegalArgumentException("Category must not be empty.");
        }
    }
}
