package com.tasklinker.tasklinker.profiles.domain.model.entities;

import com.tasklinker.tasklinker.profiles.domain.model.commands.CreateWorkerCommand;
import com.tasklinker.tasklinker.profiles.domain.model.valueobjects.*;
import com.tasklinker.tasklinker.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Worker extends AuditableAbstractAggregateRoot<Worker> {

    @Embedded
    private Address address;
    @Embedded
    EmailAddress emailAddress;
    @Embedded
    private Experience experience;
    @Embedded
    private FullName fullName;
    @Embedded
    private PhoneNumber phoneNumber;
    @Embedded
    private Rating rating;
    @Embedded
    private Skills skills;
    @Embedded
    private Photo photo;

    public Worker() {
    }

    public Worker(String firstname, String lastname, String emailAddress, String street, String numberStreet,
            String district, String postalCode, String city, String country, String area, Double experienceWorking,
            String countryCode, String number, Double value, String skillName, String descriptionSkill,
            String photoUrl) {

        this.address = new Address(street, numberStreet, district, postalCode, city, country);
        this.emailAddress = new EmailAddress(emailAddress);
        this.experience = new Experience(area, experienceWorking);
        this.fullName = new FullName(firstname, lastname);
        this.phoneNumber = new PhoneNumber(countryCode, number);
        this.rating = new Rating(value);
        this.skills = new Skills(skillName, descriptionSkill);
        this.photo = new Photo(photoUrl);

    }

    public Worker(CreateWorkerCommand command) {

        this.address = new Address(command.street(), command.numberStreet(), command.district(), command.postalCode(),
                command.city(), command.country());
        this.emailAddress = new EmailAddress(command.emailAddress());
        this.experience = new Experience(command.area(), command.experienceWorking());
        this.fullName = new FullName(command.firstname(), command.lastname());
        this.phoneNumber = new PhoneNumber(command.countryCode(), command.number());
        this.rating = new Rating(command.value());
        this.skills = new Skills(command.skillName(), command.descriptionSkill());
        this.photo = new Photo(command.photoUrl());

    }

    public FullName getFullName() {
        return fullName;
    }

    public Address getAddress() {
        return address;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public Experience getExperience() {
        return experience;
    }

    public Rating getRating() {
        return rating;
    }

    public Skills getSkills() {
        return skills;
    }

    public EmailAddress getEmailAddress() {
        return emailAddress;
    }

    public Photo getPhoto() {
        return photo;
    }

}