package com.tasklinker.tasklinker.profiles.interfaces.rest.transform;

import com.tasklinker.tasklinker.profiles.domain.model.entities.Worker;
import com.tasklinker.tasklinker.profiles.interfaces.rest.resources.WorkerResource;

public class WorkerResourceFromEntityAssembler {
        public static WorkerResource toResourceFromEntity(Worker entity) {
                return new WorkerResource(
                                entity.getId(),
                                entity.getFullName().firstname(),
                                entity.getFullName().lastname(),
                                entity.getEmailAddress().address(),
                                entity.getAddress().street(),
                                entity.getAddress().numberStreet(),
                                entity.getAddress().district(),
                                entity.getAddress().postalCode(),
                                entity.getAddress().city(),
                                entity.getAddress().country(),
                                entity.getExperience().area(),
                                entity.getExperience().experienceWorking(),
                                entity.getPhoneNumber().countryCode(),
                                entity.getPhoneNumber().number(),
                                entity.getRating().value(),
                                entity.getSkills().skillName(),
                                entity.getSkills().descriptionSkill(),
                                entity.getPhoto().photoUrl());
        }
}