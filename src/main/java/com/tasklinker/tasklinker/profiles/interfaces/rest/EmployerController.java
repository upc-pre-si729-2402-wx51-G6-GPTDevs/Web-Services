package com.tasklinker.tasklinker.profiles.interfaces.rest;

import com.tasklinker.tasklinker.profiles.domain.model.commands.DeleteEmployerByIdCommand;
import com.tasklinker.tasklinker.profiles.domain.model.commands.UpdateEmployerByIdCommand;
import com.tasklinker.tasklinker.profiles.domain.model.entities.Employer;
import com.tasklinker.tasklinker.profiles.domain.model.exceptions.ResourceNotFoundException;
import com.tasklinker.tasklinker.profiles.domain.model.queries.GetAllEmployersQuery;
import com.tasklinker.tasklinker.profiles.domain.model.queries.GetEmployerByIdQuery;
import com.tasklinker.tasklinker.profiles.domain.services.EmployerCommandService;
import com.tasklinker.tasklinker.profiles.domain.services.EmployerQueryService;
import com.tasklinker.tasklinker.profiles.interfaces.rest.resources.CreateEmployerResource;
import com.tasklinker.tasklinker.profiles.interfaces.rest.resources.EmployerResource;
import com.tasklinker.tasklinker.profiles.interfaces.rest.transform.CreateEmployerCommandFromResourceAssembler;
import com.tasklinker.tasklinker.profiles.interfaces.rest.transform.EmployerResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/employerProfile", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Employers Profiles", description = "Employer Profile Management Endpoints")
public class EmployerController {

    private final EmployerCommandService employerCommandService;
    private final EmployerQueryService employerQueryService;

    public EmployerController(EmployerCommandService employerCommandService, EmployerQueryService employerQueryService) {
        this.employerCommandService = employerCommandService;
        this.employerQueryService = employerQueryService;
    }

    /**
     * **Endpoint to create an employer profile**
     * @param resource the resource containing the necessary data to create the employer profile
     * @return the created employer profile resource with HTTP status 201 (CREATED)
     */
    @PostMapping
    public ResponseEntity<EmployerResource> createEmployerProfile(@RequestBody CreateEmployerResource resource){
        var createEmployerCommand = CreateEmployerCommandFromResourceAssembler.toCommandFromResource(resource);
        var employerProfile = employerCommandService.handle(createEmployerCommand);
        if(employerProfile.isEmpty()) return ResponseEntity.badRequest().build();
        var employerProfileResource = EmployerResourceFromEntityAssembler.toResourceFromEntity(employerProfile.get());
        return new ResponseEntity<>(employerProfileResource, HttpStatus.CREATED);
    }

    /**
     * Retrieves an employer profile by its id
     * @param id the id of the employer profile to retrieve
     * @return the Employer resource associated with the given Employer id
     */
    @GetMapping("/{id}")
    public ResponseEntity<EmployerResource> getEmployerProfileById(@PathVariable Long id){
        var getEmployerProfileByIdQuery = new GetEmployerByIdQuery(id);
        var employerProfile = employerQueryService.handle(getEmployerProfileByIdQuery);
        if(employerProfile.isEmpty()) return ResponseEntity.badRequest().build();
        var employerProfileResource = EmployerResourceFromEntityAssembler.toResourceFromEntity(employerProfile.get());
        return ResponseEntity.ok(employerProfileResource);
    }

    /**
     * **Endpoint to retrieve all employer profiles**
     * @return a list of employer profile resources if found, or HTTP status 204 (NO CONTENT) if not
     */
    @GetMapping
    public ResponseEntity<List<EmployerResource>> getAllEmployersProfiles() {
        var getAllEmployersProfilesQuery = new GetAllEmployersQuery();
        var employerProfiles = employerQueryService.handle(getAllEmployersProfilesQuery);

        if (employerProfiles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        var employerProfileResources = employerProfiles.stream()
                .map(EmployerResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());

        return ResponseEntity.ok(employerProfileResources);
    }

    /**
     * **Endpoint to update an existing employer profile**
     * @param id the ID of the employer profile to update
     * @param command object containing the updated employer data
     * @return the updated profile if found and updated, or HTTP status 404 (NOT FOUND) if not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<Employer> updateEmployerProfile(@PathVariable Long id, @RequestBody UpdateEmployerByIdCommand command) {
        UpdateEmployerByIdCommand updatedCommand = new UpdateEmployerByIdCommand(
                id,
                command.firstname(),
                command.lastname(),
                command.location(),
                command.name(),
                command.numberOfEmployees(),
                command.website(),
                command.industryName(),
                command.countryCode(),
                command.number(),
                command.photoUrl(),
                command.paymentMethod()
        );

        Optional<Employer> updatedProfileOpt = employerCommandService.handle(updatedCommand);

        return updatedProfileOpt.map(employerProfile -> new ResponseEntity<>(employerProfile, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * **Endpoint to delete an employer profile by its ID**
     * @param id the ID of the employer profile to delete
     * @return HTTP status 204 (NO CONTENT) if successfully deleted, or 404 (NOT FOUND) if the profile does not exist
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployerProfile(@PathVariable Long id) {
        try {
            Optional<Employer> deletedProfile = employerCommandService.handle(new DeleteEmployerByIdCommand(id));
            return deletedProfile.isPresent() ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
