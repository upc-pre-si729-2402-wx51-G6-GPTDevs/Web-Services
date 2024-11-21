package com.tasklinker.tasklinker.profiles.infrastructure.persistence.jpa.repositories;

import com.tasklinker.tasklinker.profiles.domain.model.entities.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {
}
