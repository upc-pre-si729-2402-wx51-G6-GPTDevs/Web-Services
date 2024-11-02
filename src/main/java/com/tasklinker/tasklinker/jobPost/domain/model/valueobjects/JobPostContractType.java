package com.tasklinker.tasklinker.jobPost.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;

@Embeddable
public record ContractType(@NotBlank String type) {
    public ContractType() {
        this("Full-Time");
    }

    public ContractType {
        if (!type.equalsIgnoreCase("Full-Time") &&
            !type.equalsIgnoreCase("Part-Time") &&
            !type.equalsIgnoreCase("Freelance") &&
            !type.equalsIgnoreCase("Temporary")) {
            throw new IllegalArgumentException("Invalid contract type.");
        }
    }
}
