package com.tasklinker.tasklinker.iam.domain.services;

import java.util.Optional;

import com.tasklinker.tasklinker.iam.domain.model.aggregates.User;
import com.tasklinker.tasklinker.iam.domain.model.commands.SignInCommand;
import com.tasklinker.tasklinker.iam.domain.model.commands.SignUpCommand;

public interface UserCommandService {
    Optional<User> handle(SignUpCommand command);

    Optional<User> handle(SignInCommand command);
}
