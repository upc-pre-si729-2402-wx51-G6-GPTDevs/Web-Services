package com.tasklinker.tasklinker.jobPost.interfaces.rest.transform;

import com.tasklinker.tasklinker.jobPost.interfaces.rest.resources.JobPostResource;
import com.tasklinker.tasklinker.jobPost.domain.model.commands.CreateJobPostCommand;

public class CreateJobPostCommandFromResourceAssembler {
    public static CreateJobPostCommand toCommandFromResource(JobPostResource resource) {
        return new CreateJobPostCommand(
                resource.title(),
                resource.description(),
                resource.contractType(),
                resource.category(),
                resource.location(),
                resource.date(),
                resource.payment());
    }

}