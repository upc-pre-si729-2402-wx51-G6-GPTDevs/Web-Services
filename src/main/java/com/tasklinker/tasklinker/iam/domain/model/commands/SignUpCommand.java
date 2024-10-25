package com.tasklinker.tasklinker.iam.domain.model.commands;

import java.time.LocalDate;

public record SignUpCommand(String name, String email, String password, String phoneNumber, String cardNumber,
        LocalDate expirementDate, String securityCode) {

}
