package com.tasklinker.tasklinker.iam.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Embeddable
public record PhoneNumber(@NotBlank @Size(min = 9, max = 9) String number) {
    public PhoneNumber() {
        this(null);
    }

    public PhoneNumber {
        if (!number.startsWith("9")) {
            throw new IllegalArgumentException("The phone number must start with 9.");
        }
    }
}
