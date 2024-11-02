package com.tasklinker.tasklinker.profiles.domain.services;

import com.tasklinker.tasklinker.profiles.domain.model.aggregates.WorkerProfile;
import com.tasklinker.tasklinker.profiles.domain.model.commands.CreateWorkerProfileCommand;
import com.tasklinker.tasklinker.profiles.domain.model.commands.DeleteWorkerProfileByIdCommand;
import com.tasklinker.tasklinker.profiles.domain.model.commands.UpdateWorkerProfileByIdCommand;

import java.util.Optional;

public interface WorkerProfileCommandService {

    Optional<WorkerProfile> handle(CreateWorkerProfileCommand command);

    Optional<WorkerProfile> handle(UpdateWorkerProfileByIdCommand command);

    Optional<WorkerProfile> handle(DeleteWorkerProfileByIdCommand command);

}
