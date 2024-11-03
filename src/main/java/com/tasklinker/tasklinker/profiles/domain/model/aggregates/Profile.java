package com.tasklinker.tasklinker.profiles.domain.model.aggregates;

import com.tasklinker.tasklinker.profiles.domain.model.entities.Employer;
import com.tasklinker.tasklinker.profiles.domain.model.entities.Worker;
import jakarta.persistence.*;

import java.util.List;

public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private List<Worker> workers;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private List<Employer> employers;

}
