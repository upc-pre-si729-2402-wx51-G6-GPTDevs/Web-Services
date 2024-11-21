package com.tasklinker.tasklinker.iam.domain.model.commands;

import java.time.LocalDate;

public record SignUpCommand(String email, String password, String cardNumber,
                LocalDate expirementDate, String securityCode) {

}
