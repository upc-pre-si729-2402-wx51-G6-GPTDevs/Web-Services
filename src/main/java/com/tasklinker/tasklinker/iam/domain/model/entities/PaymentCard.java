package com.tasklinker.tasklinker.iam.domain.model.entities;

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
public class PaymentCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String cardNumber;

    @NotNull
    private LocalDate expirementDate;

    @NotBlank
    @Size(min = 3, max = 3)
    @Column(length = 3)
    private String securityCode;

    public PaymentCard() {
    }

    public PaymentCard(String cardNumber, LocalDate expirementDate, String securityCode) {
        validate(cardNumber, expirementDate, securityCode);
        this.cardNumber = cardNumber;
        this.expirementDate = expirementDate;
        this.securityCode = securityCode;
    }

    private void validate(String cardNumber, LocalDate expirationDate, String securityCode) {
        if (!cardNumber.matches("\\d{16}")) {
            throw new IllegalArgumentException("The card number must have 16 digits.");
        }
        if (securityCode.length() != 3) {
            throw new IllegalArgumentException("The security code must have 3 digits.");
        }
    }
}
