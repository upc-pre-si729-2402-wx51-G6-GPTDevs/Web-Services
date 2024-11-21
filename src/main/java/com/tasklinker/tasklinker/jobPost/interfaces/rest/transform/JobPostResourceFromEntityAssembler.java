package com.tasklinker.tasklinker.jobPost.interfaces.rest.transform;

import com.tasklinker.tasklinker.jobPost.domain.model.aggregates.JobPost;
import com.tasklinker.tasklinker.jobPost.interfaces.rest.resources.JobPostResource;

public class JobPostResourceFromEntityAssembler {
    public static JobPostResource toResourceFromEntity(JobPost entity) {
        return new JobPostResource(
                entity.getTitle(),
                entity.getDescription(),
                entity.getContractType(),
                entity.getCategory(),
                entity.getLocation(),
                entity.getDate(),
                entity.getPayment());
    }
}
