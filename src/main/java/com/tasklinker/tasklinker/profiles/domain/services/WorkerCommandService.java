package com.tasklinker.tasklinker.profiles.domain.services;

import com.tasklinker.tasklinker.profiles.domain.model.entities.Worker;
import com.tasklinker.tasklinker.profiles.domain.model.commands.CreateWorkerCommand;
import com.tasklinker.tasklinker.profiles.domain.model.commands.DeleteWorkerByIdCommand;
import com.tasklinker.tasklinker.profiles.domain.model.commands.UpdateWorkerByIdCommand;

import java.util.Optional;

public interface WorkerCommandService {

    Optional<Worker> handle(CreateWorkerCommand command);

    Optional<Worker> handle(UpdateWorkerByIdCommand command);

    Optional<Worker> handle(DeleteWorkerByIdCommand command);

}
