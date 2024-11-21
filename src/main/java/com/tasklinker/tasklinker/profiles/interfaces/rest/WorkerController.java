package com.tasklinker.tasklinker.profiles.interfaces.rest;

import com.tasklinker.tasklinker.profiles.domain.model.entities.Worker;
import com.tasklinker.tasklinker.profiles.domain.model.commands.DeleteWorkerByIdCommand;
import com.tasklinker.tasklinker.profiles.domain.model.commands.UpdateWorkerByIdCommand;
import com.tasklinker.tasklinker.profiles.domain.model.queries.GetAllWorkersQuery;
import com.tasklinker.tasklinker.profiles.domain.model.queries.GetWorkerByIdQuery;
import com.tasklinker.tasklinker.profiles.domain.services.WorkerCommandService;
import com.tasklinker.tasklinker.profiles.domain.services.WorkerQueryService;
import com.tasklinker.tasklinker.profiles.interfaces.rest.resources.CreateWorkerResource;
import com.tasklinker.tasklinker.profiles.interfaces.rest.resources.WorkerResource;
import com.tasklinker.tasklinker.profiles.interfaces.rest.transform.CreateWorkerCommandFromResourceAssembler;
import com.tasklinker.tasklinker.profiles.interfaces.rest.transform.WorkerResourceFromEntityAssembler;
import com.tasklinker.tasklinker.profiles.domain.model.exceptions.ResourceNotFoundException;
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
public class WorkerController {

    private final WorkerCommandService workerProfileCommandService;
    private final WorkerQueryService workerProfileQueryService;

    public WorkerController(WorkerCommandService workerProfileCommandService, WorkerQueryService workerProfileQueryService) {
        this.workerProfileCommandService = workerProfileCommandService;
        this.workerProfileQueryService = workerProfileQueryService;
    }

    /**
     * **Endpoint to create a worker profile**
     * @param resource the resource containing the necessary data to create the worker profile
     * @return the created worker profile resource with HTTP status 201 (CREATED)
     */
    @PostMapping
    public ResponseEntity<WorkerResource> createWorkerProfile(@RequestBody CreateWorkerResource resource){
        var createWorkerProfileCommand = CreateWorkerCommandFromResourceAssembler.toCommandFromResource(resource);
        var workerProfile = workerProfileCommandService.handle(createWorkerProfileCommand);
        if(workerProfile.isEmpty()) return ResponseEntity.badRequest().build();
        var WorkerProfileResource = WorkerResourceFromEntityAssembler.toResourceFromEntity(workerProfile.get());
        return new ResponseEntity<>(WorkerProfileResource, HttpStatus.CREATED);
    }

    /**
     * Retrieves a profile by its id
     * @param id the id of the profile to retrieve
     * @return the Profile resource associated with the given Profile id
     */
    @GetMapping("/{id}")
    public ResponseEntity<WorkerResource> getWorkerProfileById(@PathVariable Long id){
        var getWorkerProfileByIdQuery = new GetWorkerByIdQuery(id);
        var workerProfile = workerProfileQueryService.handle(getWorkerProfileByIdQuery);
        if(workerProfile.isEmpty()) return ResponseEntity.badRequest().build();
        var workerProfileResource = WorkerResourceFromEntityAssembler.toResourceFromEntity(workerProfile.get());
        return ResponseEntity.ok(workerProfileResource);
    }

    /**
     * **Endpoint to retrieve all worker profiles**
     * @return a list of worker profile resources if found, or HTTP status 204 (NO CONTENT) if not
     */
    @GetMapping
    public ResponseEntity<List<WorkerResource>> getAllWorkersProfiles() {
        var getAllWorkersProfilesQuery = new GetAllWorkersQuery();
        var workerProfiles = workerProfileQueryService.handle(getAllWorkersProfilesQuery);

        if (workerProfiles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        var workerProfileResources = workerProfiles.stream().map(WorkerResourceFromEntityAssembler::toResourceFromEntity).collect(Collectors.toList());

        return ResponseEntity.ok(workerProfileResources);
    }

    /**
     * **Endpoint to update an existing worker profile**
     * @param id the ID of the worker profile to update
     * @param command object containing the updated worker data
     * @return the updated profile if found and updated, or HTTP status 404 (NOT FOUND) if not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<Worker> updateWorkerProfile(@PathVariable Long id, @RequestBody UpdateWorkerByIdCommand command) {
        UpdateWorkerByIdCommand updatedCommand = new UpdateWorkerByIdCommand(
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

        Optional<Worker> updatedProfileOpt = workerProfileCommandService.handle(updatedCommand);

        return updatedProfileOpt.map(workerProfile -> new ResponseEntity<>(workerProfile, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * **Endpoint to delete a worker profile by its ID**
     * @param id the ID of the worker profile to delete
     * @return HTTP status 204 (NO CONTENT) if successfully deleted, or 404 (NOT FOUND) if the profile does not exist
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkerProfile(@PathVariable Long id) {
        try {
            Optional<Worker> deletedProfile = workerProfileCommandService.handle(new DeleteWorkerByIdCommand(id));
            return deletedProfile.isPresent() ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
