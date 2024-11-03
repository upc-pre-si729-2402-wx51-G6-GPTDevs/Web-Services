package com.tasklinker.tasklinker.profiles.interfaces.rest.transform;

import com.tasklinker.tasklinker.profiles.domain.model.entities.Worker;
import com.tasklinker.tasklinker.profiles.interfaces.rest.resources.WorkerResource;

public class WorkerResourceFromEntityAssembler {
    public static WorkerResource toResourceFromEntity(Worker entity){
        return new WorkerResource(
                entity.getId(),
                entity.getAddress(),
                entity.getEmailAddress(),
                entity.getExperience(),
                entity.getFullName(),
                entity.getPhoneNumber(),
                entity.getRating(),
                entity.getSkills(),
                entity.getPhoto());
    }
}