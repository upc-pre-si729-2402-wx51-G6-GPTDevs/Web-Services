package com.tasklinker.tasklinker.profiles.interfaces.rest.transform;

import com.tasklinker.tasklinker.profiles.domain.model.commands.CreateWorkerCommand;
import com.tasklinker.tasklinker.profiles.interfaces.rest.resources.CreateWorkerResource;

public class CreateWorkerCommandFromResourceAssembler {
    public static CreateWorkerCommand toCommandFromResource (CreateWorkerResource resource){
        return new CreateWorkerCommand(resource.firstname(),
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
