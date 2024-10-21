package com.tasklinker.tasklinker.profiles.infrastructure.persistence.jpa.repositories;

import com.tasklinker.tasklinker.profiles.domain.model.aggregates.WorkerProfile;
import org.hibernate.jdbc.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerProfileRepository extends JpaRepository<WorkerProfile, Long> {
}
