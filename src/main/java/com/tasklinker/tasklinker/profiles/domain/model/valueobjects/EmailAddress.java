package com.tasklinker.tasklinker.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;

@Embeddable
public record EmailAddress(@Email String address){
    public EmailAddress() {this(null);}

    public String getEmail() {
        return address;
    }
}
