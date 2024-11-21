package com.tasklinker.tasklinker.iam.interfaces.rest.transform;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.tasklinker.tasklinker.iam.domain.model.commands.SignUpCommand;
import com.tasklinker.tasklinker.iam.interfaces.rest.resources.SignUpResource;

public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        LocalDate expirementDate;

        try {
            expirementDate = LocalDate.parse("01-" + resource.expirementDate(),
                    DateTimeFormatter.ofPattern("dd-MM-yy"));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Date format must be MM-yy", e);
        }

        return new SignUpCommand(
                resource.email(),
                resource.password(),
                resource.cardNumber(),
                expirementDate,
                resource.securityCode());
    }
}
