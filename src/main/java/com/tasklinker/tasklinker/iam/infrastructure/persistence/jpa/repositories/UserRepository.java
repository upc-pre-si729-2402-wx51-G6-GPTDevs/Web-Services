package com.tasklinker.tasklinker.iam.infrastructure.persistence.jpa.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tasklinker.tasklinker.iam.domain.model.aggregates.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * This method is responsible for finding the user by username.
     * 
     * @param email The username.
     * @return The user object.
     */
    Optional<User> findByEmail(String email);

    /**
     * This method is responsible for checking if the user exists by username.
     * 
     * @param email The username.
     * @return True if the user exists, false otherwise.
     */
    boolean existsByEmail(String email);
}
