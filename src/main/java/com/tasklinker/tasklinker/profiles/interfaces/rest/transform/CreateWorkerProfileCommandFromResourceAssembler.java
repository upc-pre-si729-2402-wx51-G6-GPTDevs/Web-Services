package com.tasklinker.tasklinker.profiles.interfaces.rest.transform;

import com.tasklinker.tasklinker.profiles.domain.model.commands.CreateWorkerProfileCommand;
import com.tasklinker.tasklinker.profiles.interfaces.rest.resources.CreateWorkerProfileResource;

public class CreateWorkerProfileCommandFromResourceAssembler {
    public static CreateWorkerProfileCommand toCommandFromResource (CreateWorkerProfileResource resource){

        return new CreateWorkerProfileCommand(resource.firstname(),
                resource.lastname(),
                resource.emailAddress(),
                resource.street(),
                resource.numberStreet(),
                resource.district(),
                resource.postalCode(),
                resource.city(),
                resource.country(),
                resource.area(),
                resource.experienceWorking(),
                resource.countryCode(),
                resource.number(),
                resource.value(),
                resource.skillName(),
                resource.descriptionSkill(),
                resource.photoUrl()
                );

    }
}
