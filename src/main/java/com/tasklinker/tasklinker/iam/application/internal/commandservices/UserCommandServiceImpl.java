package com.tasklinker.tasklinker.iam.application.internal.commandservices;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tasklinker.tasklinker.iam.application.internal.outboundservices.tokens.jwt.TokenService;
import com.tasklinker.tasklinker.iam.domain.model.aggregates.User;
import com.tasklinker.tasklinker.iam.domain.model.commands.SignInCommand;
import com.tasklinker.tasklinker.iam.domain.model.commands.SignUpCommand;
import com.tasklinker.tasklinker.iam.domain.services.UserCommandService;
import com.tasklinker.tasklinker.iam.infrastructure.persistence.jpa.repositories.UserRepository;

@Service
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;
    private final TokenService tokenService;

    public UserCommandServiceImpl(UserRepository userRepository, TokenService tokenService) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
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
    public Optional<String> handle(SignInCommand command) {
        var user = userRepository.findByEmail(command.email());

        if (user.isEmpty())
            throw new RuntimeException("User not found");

        if (!command.password().equals(user.get().getPassword()))
            throw new RuntimeException("Invalid password");

        var token = tokenService.generateToke(
                user.get().getId(),
                user.get().getName(),
                user.get().getEmail());

        return Optional.of(token);
        // return Optional.of(user.get());
    }
}
