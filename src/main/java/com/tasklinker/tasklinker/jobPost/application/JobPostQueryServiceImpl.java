package com.tasklinker.tasklinker.jobPost.application;

import java.util.Optional;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tasklinker.tasklinker.jobPost.domain.model.aggregates.JobPost;
import com.tasklinker.tasklinker.jobPost.domain.model.queries.GetJobPostByIdQuery;
import com.tasklinker.tasklinker.jobPost.domain.model.queries.ListAllJobPostsQuery;
import com.tasklinker.tasklinker.jobPost.domain.services.JobPostQueryService;
import com.tasklinker.tasklinker.jobPost.infrastructure.persistence.jpa.repositories.JobPostRepository;

@Service
public class JobPostQueryServiceImpl implements JobPostQueryService {
    private final JobPostRepository jobPostRepository;

    public JobPostQueryServiceImpl(JobPostRepository jobPostRepository) {
        this.jobPostRepository = jobPostRepository;
    }

    @Override
    public Optional<JobPost> handle(GetJobPostByIdQuery query) {
        return jobPostRepository.findById(query.id());
    }

    @Override
    public List<JobPost> handle(ListAllJobPostsQuery query) {
        return jobPostRepository.findAll();
    }

}
