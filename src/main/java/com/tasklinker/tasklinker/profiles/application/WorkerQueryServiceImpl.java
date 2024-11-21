package com.tasklinker.tasklinker.profiles.application;

import com.tasklinker.tasklinker.profiles.domain.model.entities.Worker;
import com.tasklinker.tasklinker.profiles.domain.model.queries.GetAllWorkersQuery;
import com.tasklinker.tasklinker.profiles.domain.model.queries.GetWorkerByIdQuery;
import com.tasklinker.tasklinker.profiles.domain.services.WorkerQueryService;
import com.tasklinker.tasklinker.profiles.infrastructure.persistence.jpa.repositories.WorkerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerQueryServiceImpl implements WorkerQueryService {

    private final WorkerRepository workerRepository;

    public WorkerQueryServiceImpl(WorkerRepository workerProfileRepository) {
        this.workerRepository = workerProfileRepository;
    }

    @Override
    public Optional<Worker> handle(GetWorkerByIdQuery query) {
        return workerRepository.findById(query.id());
    }

    @Override
    public List<Worker> handle(GetAllWorkersQuery query) {
        return workerRepository.findAll();
    }
}
