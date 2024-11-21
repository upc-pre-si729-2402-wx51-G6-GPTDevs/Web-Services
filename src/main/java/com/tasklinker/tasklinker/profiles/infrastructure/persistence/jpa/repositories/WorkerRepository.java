package com.tasklinker.tasklinker.profiles.infrastructure.persistence.jpa.repositories;

import com.tasklinker.tasklinker.profiles.domain.model.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
