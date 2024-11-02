package com.tasklinker.tasklinker.jobPost.application;

import java.util.Optional;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tasklinker.tasklinker.jobPost.domain.model.aggregates.JobPost;
//import com.tasklinker.tasklinker.jobPost.domain.model.queries.FindJobPostByIdQuery;
//import com.tasklinker.tasklinker.jobPost.domain.model.queries.ListJobPostsQuery;
import com.tasklinker.tasklinker.jobPost.domain.services.JobPostQueryService;
import com.tasklinker.tasklinker.jobPost.infrastructure.persistence.jpa.repositories.JobPostRepository;

@Service
public class JobPostQueryServiceImpl implements JobPostQueryService {
    private final JobPostRepository jobPostRepository;

    public JobPostQueryServiceImpl(JobPostRepository jobPostRepository) {
        this.jobPostRepository = jobPostRepository;
    }

    /*
     * @Override
     * public Optional<JobPost> handle(FindJobPostByIdQuery query) {
     * return jobPostRepository.findById(query.getJobPostId());
     * }
     * 
     * @Override
     * public List<JobPost> handle(ListJobPostsQuery query) {
     * return jobPostRepository.findAll();
     * }
     */
}
