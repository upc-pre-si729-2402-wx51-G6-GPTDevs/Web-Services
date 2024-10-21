package com.tasklinker.tasklinker.profiles.application;

import com.tasklinker.tasklinker.profiles.domain.model.aggregates.WorkerProfile;
import com.tasklinker.tasklinker.profiles.domain.model.commands.CreateWorkerProfileCommand;
import com.tasklinker.tasklinker.profiles.domain.model.commands.DeleteWorkerProfileByIdCommand;
import com.tasklinker.tasklinker.profiles.domain.model.commands.UpdateWorkerProfileByIdCommand;
import com.tasklinker.tasklinker.profiles.domain.model.valueobjects.*;
import com.tasklinker.tasklinker.profiles.domain.services.WorkerProfileCommandService;
import com.tasklinker.tasklinker.profiles.infrastructure.persistence.jpa.repositories.WorkerProfileRepository;
import com.tasklinker.tasklinker.shared.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WorkerProfileCommandServiceImpl implements WorkerProfileCommandService {

    private final WorkerProfileRepository workerProfileRepository;

    public WorkerProfileCommandServiceImpl(WorkerProfileRepository workerProfileRepository){
        this.workerProfileRepository =workerProfileRepository;
    }

    @Override
    public Optional<WorkerProfile> handle(CreateWorkerProfileCommand command) {

        var workerProfile = new WorkerProfile(command);
        var createdWorkerProfile = workerProfileRepository.save(workerProfile);
        return Optional.of(createdWorkerProfile);
    }

    public Optional<WorkerProfile> handle(UpdateWorkerProfileByIdCommand command) {
        Optional<WorkerProfile> existingProfileOpt = workerProfileRepository.findById(command.id());

        if (existingProfileOpt.isEmpty()) {
            return Optional.empty();
        }

        WorkerProfile existingProfile = existingProfileOpt.get();

        WorkerFullName updatedFullName = new WorkerFullName(command.firstname(), command.lastname());
        WorkerEmailAddress updatedEmailAddress = new WorkerEmailAddress(command.emailAddress());
        WorkerAddress updatedAddress = new WorkerAddress(command.street(), command.numberStreet(), command.district(), command.postalCode(), command.city(), command.country());
        WorkerExperience updatedExperience = new WorkerExperience(command.area(), command.experienceWorking());
        WorkerPhoneNumber updatedPhoneNumber = new WorkerPhoneNumber(command.countryCode(), command.number());
        WorkerRating updatedRating = new WorkerRating(command.value());
        WorkerSkills updatedSkills = new WorkerSkills(command.skillName(), command.descriptionSkill());
        WorkerPhoto updatedPhoto = new WorkerPhoto(command.photoUrl());


        existingProfile.setFullName(updatedFullName);
        existingProfile.setEmailAddress(updatedEmailAddress);
        existingProfile.setAddress(updatedAddress);
        existingProfile.setExperience(updatedExperience);
        existingProfile.setPhoneNumber(updatedPhoneNumber);
        existingProfile.setRating(updatedRating);
        existingProfile.setSkills(updatedSkills);
        existingProfile.setPhoto(updatedPhoto);

        workerProfileRepository.save(existingProfile);

        return Optional.of(existingProfile);
    }

    public Optional<WorkerProfile> handle(DeleteWorkerProfileByIdCommand command) {
        Optional<WorkerProfile> existingProfileOpt = workerProfileRepository.findById(command.id());

        if (existingProfileOpt.isPresent()) {
            WorkerProfile existingProfile = existingProfileOpt.get();
            workerProfileRepository.delete(existingProfile);
            return Optional.of(existingProfile); 
        } else {
            throw new ResourceNotFoundException("Worker profile with id " + command.id() + " not found.");
        }
    }


}
