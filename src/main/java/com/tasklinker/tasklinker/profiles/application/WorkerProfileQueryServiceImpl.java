package com.tasklinker.tasklinker.profiles.application;

import com.tasklinker.tasklinker.profiles.domain.model.aggregates.WorkerProfile;
import com.tasklinker.tasklinker.profiles.domain.model.queries.GetAllWorkersProfilesQuery;
import com.tasklinker.tasklinker.profiles.domain.model.queries.GetWorkerProfileByIdQuery;
import com.tasklinker.tasklinker.profiles.domain.services.WorkerProfileQueryService;
import com.tasklinker.tasklinker.profiles.infrastructure.persistence.jpa.repositories.WorkerProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerProfileQueryServiceImpl implements WorkerProfileQueryService {

    private final WorkerProfileRepository workerProfileRepository;

    public WorkerProfileQueryServiceImpl(WorkerProfileRepository workerProfileRepository) {
        this.workerProfileRepository = workerProfileRepository;
    }

    @Override
    public Optional<WorkerProfile> handle(GetWorkerProfileByIdQuery query) {
        return workerProfileRepository.findById(query.id());
    }

    @Override
    public List<WorkerProfile> handle(GetAllWorkersProfilesQuery query) {
        return workerProfileRepository.findAll();
    }
}
