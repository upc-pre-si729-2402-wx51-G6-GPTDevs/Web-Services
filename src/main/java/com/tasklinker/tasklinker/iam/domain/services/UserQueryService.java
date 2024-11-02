package com.tasklinker.tasklinker.iam.domain.services;

import java.util.Optional;

import com.tasklinker.tasklinker.iam.domain.model.aggregates.User;
import com.tasklinker.tasklinker.iam.domain.model.queries.GetUserByEmailQuery;

public interface UserQueryService {
    Optional<User> handle(GetUserByEmailQuery query);
}
