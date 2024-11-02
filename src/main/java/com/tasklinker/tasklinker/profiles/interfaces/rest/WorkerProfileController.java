package com.tasklinker.tasklinker.profiles.interfaces.rest;

import com.tasklinker.tasklinker.profiles.domain.model.aggregates.WorkerProfile;
import com.tasklinker.tasklinker.profiles.domain.model.commands.DeleteWorkerProfileByIdCommand;
import com.tasklinker.tasklinker.profiles.domain.model.commands.UpdateWorkerProfileByIdCommand;
import com.tasklinker.tasklinker.profiles.domain.model.queries.GetAllWorkersProfilesQuery;
import com.tasklinker.tasklinker.profiles.domain.model.queries.GetWorkerProfileByIdQuery;
import com.tasklinker.tasklinker.profiles.domain.services.WorkerProfileCommandService;
import com.tasklinker.tasklinker.profiles.domain.services.WorkerProfileQueryService;
import com.tasklinker.tasklinker.profiles.interfaces.rest.resources.CreateWorkerProfileResource;
import com.tasklinker.tasklinker.profiles.interfaces.rest.resources.WorkerProfileResource;
import com.tasklinker.tasklinker.profiles.interfaces.rest.transform.CreateWorkerProfileCommandFromResourceAssembler;
import com.tasklinker.tasklinker.profiles.interfaces.rest.transform.WorkerProfileResourceFromEntityAssembler;
import com.tasklinker.tasklinker.shared.exceptions.ResourceNotFoundException;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/workerProfile", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Workers Profiles", description = "Worker Profile Management Endpoints")
public class WorkerProfileController {

    private final WorkerProfileCommandService workerProfileCommandService;
    private final WorkerProfileQueryService workerProfileQueryService;

    public WorkerProfileController(WorkerProfileCommandService workerProfileCommandService, WorkerProfileQueryService workerProfileQueryService) {
        this.workerProfileCommandService = workerProfileCommandService;
        this.workerProfileQueryService = workerProfileQueryService;
    }

    @PostMapping
    public ResponseEntity<WorkerProfileResource> createWorkerProfile(@RequestBody CreateWorkerProfileResource resource){
        var createWorkerProfileCommand = CreateWorkerProfileCommandFromResourceAssembler.toCommandFromResource(resource);
        var workerProfile = workerProfileCommandService.handle(createWorkerProfileCommand);
        if(workerProfile.isEmpty()) return ResponseEntity.badRequest().build();
        var WorkerProfileResource = WorkerProfileResourceFromEntityAssembler.toResourceFromEntity(workerProfile.get());
        return new ResponseEntity<>(WorkerProfileResource, HttpStatus.CREATED);
    }

    /**
     * Retrieves a profile by its id
     * @param id the id of the profile to retrieve
     * @return the Profile resource associated with the given Profile id
     */
    @GetMapping("/{id}")
    public ResponseEntity<WorkerProfileResource> getWorkerProfileById(@PathVariable Long id){
        var getWorkerProfileByIdQuery = new GetWorkerProfileByIdQuery(id);
        var workerProfile = workerProfileQueryService.handle(getWorkerProfileByIdQuery);
        if(workerProfile.isEmpty()) return ResponseEntity.badRequest().build();
        var workerProfileResource = WorkerProfileResourceFromEntityAssembler.toResourceFromEntity(workerProfile.get());
        return ResponseEntity.ok(workerProfileResource);
    }

    @GetMapping
    public ResponseEntity<List<WorkerProfileResource>> getAllWorkersProfiles() {
        var getAllWorkersProfilesQuery = new GetAllWorkersProfilesQuery();
        var workerProfiles = workerProfileQueryService.handle(getAllWorkersProfilesQuery);

        if (workerProfiles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        var workerProfileResources = workerProfiles.stream().map(WorkerProfileResourceFromEntityAssembler::toResourceFromEntity).collect(Collectors.toList());

        return ResponseEntity.ok(workerProfileResources);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkerProfile> updateWorkerProfile(@PathVariable Long id, @RequestBody UpdateWorkerProfileByIdCommand command) {
        UpdateWorkerProfileByIdCommand updatedCommand = new UpdateWorkerProfileByIdCommand(
                id,
                command.firstname(),
                command.lastname(),
                command.emailAddress(),
                command.street(),
                command.numberStreet(),
                command.district(),
                command.postalCode(),
                command.city(),
                command.country(),
                command.area(),
                command.experienceWorking(),
                command.countryCode(),
                command.number(),
                command.value(),
                command.skillName(),
                command.descriptionSkill(),
                command.photoUrl()
                );

        Optional<WorkerProfile> updatedProfileOpt = workerProfileCommandService.handle(updatedCommand);

        return updatedProfileOpt.map(workerProfile -> new ResponseEntity<>(workerProfile, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkerProfile(@PathVariable Long id) {
        try {
            Optional<WorkerProfile> deletedProfile = workerProfileCommandService.handle(new DeleteWorkerProfileByIdCommand(id));
            return deletedProfile.isPresent() ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
