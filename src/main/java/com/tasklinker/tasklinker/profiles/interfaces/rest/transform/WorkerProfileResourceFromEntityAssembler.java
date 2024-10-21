package com.tasklinker.tasklinker.profiles.interfaces.rest.transform;

import com.tasklinker.tasklinker.profiles.domain.model.aggregates.WorkerProfile;
import com.tasklinker.tasklinker.profiles.interfaces.rest.resources.WorkerProfileResource;

public class WorkerProfileResourceFromEntityAssembler {
    public static WorkerProfileResource toResourceFromEntity(WorkerProfile entity){
        return new WorkerProfileResource(
                entity.getId(),
                entity.getWorkerAddress(),
                entity.getWorkerEmailAddress(),
                entity.getWorkerExperience(),
                entity.getWorkerFullName(),
                entity.getWorkerPhoneNumber(),
                entity.getWorkerRating(),
                entity.getWorkerSkills(),
                entity.getWorkerPhoto());
    }
}