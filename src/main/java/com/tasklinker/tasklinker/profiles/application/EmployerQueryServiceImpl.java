package com.tasklinker.tasklinker.profiles.application;

import com.tasklinker.tasklinker.profiles.domain.model.entities.Employer;
import com.tasklinker.tasklinker.profiles.domain.model.queries.GetAllEmployersQuery;
import com.tasklinker.tasklinker.profiles.domain.model.queries.GetEmployerByIdQuery;
import com.tasklinker.tasklinker.profiles.domain.services.EmployerQueryService;
import com.tasklinker.tasklinker.profiles.infrastructure.persistence.jpa.repositories.EmployerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployerQueryServiceImpl implements EmployerQueryService {

    private final EmployerRepository employerRepository;

    public EmployerQueryServiceImpl(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    @Override
    public Optional<Employer> handle(GetEmployerByIdQuery query) {
        return employerRepository.findById(query.id());
    }

    @Override
    public List<Employer> handle(GetAllEmployersQuery query) {
        return employerRepository.findAll();
    }
}
