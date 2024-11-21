package com.tasklinker.tasklinker.profiles.domain.model.valueobjects;

public record PaymentMethod(String paymentMethod) {
    public PaymentMethod() {this(null);}
    public PaymentMethod {
        if (paymentMethod == null || paymentMethod.isBlank()) {
            throw new IllegalArgumentException("Payment method cannot be empty");
        }
    }
    public String getPaymentMethod() {
        return String.format("%s",paymentMethod);
    }
}
