package com.tasklinker.tasklinker.profiles.domain.services;

import com.tasklinker.tasklinker.profiles.domain.model.entities.Employer;
import com.tasklinker.tasklinker.profiles.domain.model.queries.GetAllEmployersQuery;
import com.tasklinker.tasklinker.profiles.domain.model.queries.GetEmployerByIdQuery;

import java.util.List;
import java.util.Optional;

public interface EmployerQueryService {
    List<Employer> handle(GetAllEmployersQuery query);

    Optional<Employer> handle(GetEmployerByIdQuery query);
}
