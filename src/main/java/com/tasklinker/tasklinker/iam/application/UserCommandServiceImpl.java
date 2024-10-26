package com.tasklinker.tasklinker.iam.application;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tasklinker.tasklinker.iam.domain.model.aggregates.User;
import com.tasklinker.tasklinker.iam.domain.model.commands.SignInCommand;
import com.tasklinker.tasklinker.iam.domain.model.commands.SignUpCommand;
import com.tasklinker.tasklinker.iam.domain.services.UserCommandService;
import com.tasklinker.tasklinker.iam.infrastructure.persistence.jpa.repositories.UserRepository;

@Service
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;

    public UserCommandServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> handle(SignUpCommand command) {
        if (userRepository.existsByEmail(command.email()))
            throw new RuntimeException("Email already in use");

        var user = new User(command);
        var createdUser = userRepository.save(user);
        return Optional.of(createdUser);
    }

    @Override
    public Optional<User> handle(SignInCommand command) {
        var user = userRepository.findByEmail(command.email());

        if (user.isEmpty())
            throw new RuntimeException("User not found");

        if (!command.password().equals(user.get().getPassword()))
            throw new RuntimeException("Invalid password");

        return Optional.of(user.get());
    }
}
