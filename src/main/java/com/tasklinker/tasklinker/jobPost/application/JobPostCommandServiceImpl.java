package com.tasklinker.tasklinker.jobpost.application;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tasklinker.tasklinker.jobpost.domain.model.aggregates.JobPost;
import com.tasklinker.tasklinker.jobpost.domain.model.commands.CreateJobPostCommand;
import com.tasklinker.tasklinker.jobpost.domain.services.JobPostCommandService;
import com.tasklinker.tasklinker.jobpost.infrastructure.persistence.jpa.repositories.JobPostRepository;

@Service
public class JobPostCommandServiceImpl implements JobPostCommandService {
    private final JobPostRepository jobPostRepository;

    public JobPostCommandServiceImpl(JobPostRepository jobPostRepository) {
        this.jobPostRepository = jobPostRepository;
    }

    @Override
    public Optional<JobPost> handle(CreateJobPostCommand command) {
        var jobPost = new JobPost(command);
        var createdJobPost = jobPostRepository.save(jobPost);
        return Optional.of(createdJobPost);
    }


}
