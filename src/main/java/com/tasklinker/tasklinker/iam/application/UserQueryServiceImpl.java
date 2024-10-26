package com.tasklinker.tasklinker.iam.application;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tasklinker.tasklinker.iam.domain.model.aggregates.User;
import com.tasklinker.tasklinker.iam.domain.model.queries.GetUserByEmailQuery;
import com.tasklinker.tasklinker.iam.domain.services.UserQueryService;
import com.tasklinker.tasklinker.iam.infrastructure.persistence.jpa.repositories.UserRepository;

@Service
public class UserQueryServiceImpl implements UserQueryService {
    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> handle(GetUserByEmailQuery query) {
        return userRepository.findByEmail(query.email());
    }

}
