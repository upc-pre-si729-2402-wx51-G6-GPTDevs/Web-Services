package com.tasklinker.tasklinker.profiles.interfaces.rest.transform;

import com.tasklinker.tasklinker.profiles.domain.model.commands.CreateEmployerCommand;
import com.tasklinker.tasklinker.profiles.interfaces.rest.resources.CreateEmployerResource;

public class CreateEmployerCommandFromResourceAssembler {
    public static CreateEmployerCommand toCommandFromResource (CreateEmployerResource resource) {
        return new CreateEmployerCommand(resource.firstname(),
                resource.lastname(),
                resource.location(),
                resource.name(),
                resource.numberOfEmployees(),
                resource.website(),
                resource.industryName(),
                resource.countryCode(),
                resource.number(),
                resource.photoUrl(),
                resource.paymentMethod()
        );
    }
}
