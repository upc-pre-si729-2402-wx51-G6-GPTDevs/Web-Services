package com.tasklinker.tasklinker.profiles.application;

import com.tasklinker.tasklinker.profiles.domain.model.entities.Worker;
import com.tasklinker.tasklinker.profiles.domain.model.commands.CreateWorkerCommand;
import com.tasklinker.tasklinker.profiles.domain.model.commands.DeleteWorkerByIdCommand;
import com.tasklinker.tasklinker.profiles.domain.model.commands.UpdateWorkerByIdCommand;
import com.tasklinker.tasklinker.profiles.domain.model.valueobjects.*;
import com.tasklinker.tasklinker.profiles.domain.services.WorkerCommandService;
import com.tasklinker.tasklinker.profiles.infrastructure.persistence.jpa.repositories.WorkerRepository;
import com.tasklinker.tasklinker.profiles.domain.model.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WorkerCommandServiceImpl implements WorkerCommandService {

    private final WorkerRepository workerProfileRepository;

    public WorkerCommandServiceImpl(WorkerRepository workerProfileRepository){
        this.workerProfileRepository =workerProfileRepository;
    }

    @Override
    public Optional<Worker> handle(CreateWorkerCommand command) {

        var workerProfile = new Worker(command);
        var createdWorkerProfile = workerProfileRepository.save(workerProfile);
        return Optional.of(createdWorkerProfile);
    }

    public Optional<Worker> handle(UpdateWorkerByIdCommand command) {
        Optional<Worker> existingProfileOpt = workerProfileRepository.findById(command.id());

        if (existingProfileOpt.isEmpty()) {
            return Optional.empty();
        }

        Worker existingProfile = existingProfileOpt.get();

        FullName updatedFullName = new FullName(command.firstname(), command.lastname());
        EmailAddress updatedEmailAddress = new EmailAddress(command.emailAddress());
        Address updatedAddress = new Address(command.street(), command.numberStreet(), command.district(), command.postalCode(), command.city(), command.country());
        Experience updatedExperience = new Experience(command.area(), command.experienceWorking());
        PhoneNumber updatedPhoneNumber = new PhoneNumber(command.countryCode(), command.number());
        Rating updatedRating = new Rating(command.value());
        Skills updatedSkills = new Skills(command.skillName(), command.descriptionSkill());
        Photo updatedPhoto = new Photo(command.photoUrl());


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

    public Optional<Worker> handle(DeleteWorkerByIdCommand command) {
        Optional<Worker> existingProfileOpt = workerProfileRepository.findById(command.id());

        if (existingProfileOpt.isPresent()) {
            Worker existingProfile = existingProfileOpt.get();
            workerProfileRepository.delete(existingProfile);
            return Optional.of(existingProfile); 
        } else {
            throw new ResourceNotFoundException("Worker profile with id " + command.id() + " not found.");
        }
    }


}
