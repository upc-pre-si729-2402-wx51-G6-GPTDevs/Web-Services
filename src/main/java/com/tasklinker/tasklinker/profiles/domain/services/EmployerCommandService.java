package com.tasklinker.tasklinker.profiles.domain.services;

import com.tasklinker.tasklinker.profiles.domain.model.commands.CreateEmployerCommand;
import com.tasklinker.tasklinker.profiles.domain.model.commands.DeleteEmployerByIdCommand;
import com.tasklinker.tasklinker.profiles.domain.model.commands.UpdateEmployerByIdCommand;
import com.tasklinker.tasklinker.profiles.domain.model.entities.Employer;

import java.util.Optional;

public interface EmployerCommandService {
    Optional<Employer> handle(CreateEmployerCommand command);
    Optional<Employer> handle(UpdateEmployerByIdCommand command);
    Optional<Employer> handle(DeleteEmployerByIdCommand command);
}
