package com.tasklinker.tasklinker.profiles.domain.services;

import com.tasklinker.tasklinker.profiles.domain.model.aggregates.WorkerProfile;
import com.tasklinker.tasklinker.profiles.domain.model.queries.GetAllWorkersProfilesQuery;
import com.tasklinker.tasklinker.profiles.domain.model.queries.GetWorkerProfileByIdQuery;

import java.util.List;
import java.util.Optional;

public interface WorkerProfileQueryService {

    List<WorkerProfile> handle(GetAllWorkersProfilesQuery query);

    Optional<WorkerProfile> handle(GetWorkerProfileByIdQuery query);
}
