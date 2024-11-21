package com.tasklinker.tasklinker.jobPost.interfaces.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.tasklinker.tasklinker.jobPost.domain.model.queries.GetJobPostByIdQuery;
import com.tasklinker.tasklinker.jobPost.domain.model.queries.ListAllJobPostsQuery;
import com.tasklinker.tasklinker.jobPost.domain.services.JobPostCommandService;
import com.tasklinker.tasklinker.jobPost.domain.services.JobPostQueryService;
import com.tasklinker.tasklinker.jobPost.interfaces.rest.resources.JobPostResource;
import com.tasklinker.tasklinker.jobPost.interfaces.rest.transform.CreateJobPostCommandFromResourceAssembler;
import com.tasklinker.tasklinker.jobPost.interfaces.rest.transform.JobPostResourceFromEntityAssembler;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/api/v1/jobposts", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Job Posts", description = "Job Post Endpoints")
public class JobPostController {
    private final JobPostCommandService commandService;
    private final JobPostQueryService queryService;

    public JobPostController(JobPostCommandService commandService, JobPostQueryService queryService) {
        this.commandService = commandService;
        this.queryService = queryService;
    }

    @PostMapping()
    public ResponseEntity<JobPostResource> createPostJob(@RequestBody JobPostResource resource) {
        var command = CreateJobPostCommandFromResourceAssembler.toCommandFromResource(resource);

        var jobPost = commandService.handle(command);

        if (jobPost.isEmpty())
            return ResponseEntity.badRequest().build();

        var jobPostResource = JobPostResourceFromEntityAssembler.toResourceFromEntity(jobPost.get());

        return new ResponseEntity<>(jobPostResource, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<JobPostResource>> getAllPostJob() {
        var query = new ListAllJobPostsQuery();

        var jobPosts = queryService.handle(query);

        var jobPostResources = jobPosts.stream()
                .map(JobPostResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());

        return new ResponseEntity<>(jobPostResources, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobPostResource> getPostJobById(@PathVariable Long id) {
        var query = new GetJobPostByIdQuery(id);
        var jobPost = queryService.handle(query);

        if (jobPost.isEmpty())
            return ResponseEntity.notFound().build();

        var jobPostResource = JobPostResourceFromEntityAssembler.toResourceFromEntity(jobPost.get());

        return new ResponseEntity<>(jobPostResource, HttpStatus.OK);
    }
}
