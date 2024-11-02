package com.tasklinker.tasklinker.iam.interfaces.rest.transform;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.tasklinker.tasklinker.iam.domain.model.commands.SignUpCommand;
import com.tasklinker.tasklinker.iam.interfaces.rest.resources.SignUpResource;

public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate expirementDate;

        try {
            expirementDate = LocalDate.parse(resource.expirementDate(), formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Date format must be yyyy-MM-dd", e);
        }

        return new SignUpCommand(
                resource.name(),
                resource.email(),
                resource.password(),
                resource.phoneNumber(),
                resource.cardNumber(),
                expirementDate,
                resource.securityCode());
    }
}
