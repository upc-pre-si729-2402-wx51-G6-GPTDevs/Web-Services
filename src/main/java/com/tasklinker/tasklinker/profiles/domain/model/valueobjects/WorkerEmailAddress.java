package com.tasklinker.tasklinker.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;

@Embeddable
public record WorkerEmailAddress (@Email String address){
    public WorkerEmailAddress() {this(null);}
}
