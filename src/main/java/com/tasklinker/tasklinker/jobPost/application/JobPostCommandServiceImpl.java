package com.tasklinker.tasklinker.jobPost.application;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tasklinker.tasklinker.jobPost.domain.model.aggregates.JobPost;
import com.tasklinker.tasklinker.jobPost.domain.model.commands.CreateJobPostCommand;
import com.tasklinker.tasklinker.jobPost.domain.model.commands.UpdateJobPostCommand;
import com.tasklinker.tasklinker.jobPost.domain.services.JobPostCommandService;
import com.tasklinker.tasklinker.jobPost.infrastructure.persistence.jpa.repositories.JobPostRepository;

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

    @Override
    public Optional<JobPost> handle(UpdateJobPostCommand command) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handle'");
    }

}
