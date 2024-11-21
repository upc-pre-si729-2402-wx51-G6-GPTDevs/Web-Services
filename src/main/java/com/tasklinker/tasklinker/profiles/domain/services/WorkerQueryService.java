package com.tasklinker.tasklinker.profiles.domain.services;

import com.tasklinker.tasklinker.profiles.domain.model.entities.Worker;
import com.tasklinker.tasklinker.profiles.domain.model.queries.GetAllWorkersQuery;
import com.tasklinker.tasklinker.profiles.domain.model.queries.GetWorkerByIdQuery;

import java.util.List;
import java.util.Optional;

public interface WorkerQueryService {

    List<Worker> handle(GetAllWorkersQuery query);

    Optional<Worker> handle(GetWorkerByIdQuery query);
}
