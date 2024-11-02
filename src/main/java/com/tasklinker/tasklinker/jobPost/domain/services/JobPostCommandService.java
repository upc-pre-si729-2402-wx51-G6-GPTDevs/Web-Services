package com.tasklinker.tasklinker.jobPost.domain.services;

import java.util.Optional;

import com.tasklinker.tasklinker.jobPost.domain.model.aggregates.JobPost;
import com.tasklinker.tasklinker.jobPost.domain.model.commands.CreateJobPostCommand;
import com.tasklinker.tasklinker.jobPost.domain.model.commands.UpdateJobPostCommand;
//import com.tasklinker.tasklinker.jobPost.domain.model.commands.DeleteJobPostCommand;

public interface JobPostCommandService {

    Optional<JobPost> handle(CreateJobPostCommand command);

    Optional<JobPost> handle(UpdateJobPostCommand command);

    // void handle(DeleteJobPostCommand command);
}
