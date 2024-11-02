package com.tasklinker.tasklinker.jobPost.infrastructure.persistence.jpa.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tasklinker.tasklinker.jobPost.domain.model.aggregates.JobPost;

@Repository
public interface JobPostRepository extends JpaRepository<JobPost, Long> {

    /**
     * This method is responsible for finding a job post by title.
     *
     * @param title The title of the job post.
     * @return A list of job posts with the given title.
     */
    List<JobPost> findByTitle(String title);

    /**
     * This method is responsible for finding all job posts in a specific category.
     *
     * @param category The category of the job posts.
     * @return A list of job posts in the specified category.
     */
    List<JobPost> findByCategory(String category);

    /**
     * This method is responsible for finding job posts by location.
     *
     * @param location The location of the job posts.
     * @return A list of job posts in the specified location.
     */
    List<JobPost> findByLocation(String location);

    /**
     * This method is responsible for checking if a job post exists by title and location.
     *
     * @param title The title of the job post.
     * @param location The location of the job post.
     * @return True if a job post exists with the specified title and location, false otherwise.
     */
    boolean existsByTitleAndLocation(String title, String location);

    /**
     * This method is responsible for finding a job post by ID.
     *
     * @param id The ID of the job post.
     * @return An Optional containing the job post if found, or empty if not found.
     */
    Optional<JobPost> findById(Long id);
}
