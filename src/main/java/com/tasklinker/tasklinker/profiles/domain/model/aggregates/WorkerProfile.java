package com.tasklinker.tasklinker.profiles.domain.model.aggregates;

import com.tasklinker.tasklinker.profiles.domain.model.commands.CreateWorkerProfileCommand;
import com.tasklinker.tasklinker.profiles.domain.model.valueobjects.*;
import com.tasklinker.tasklinker.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class WorkerProfile extends AuditableAbstractAggregateRoot<WorkerProfile> {

    @Embedded
    private WorkerAddress address;

    @Embedded
    WorkerEmailAddress emailAddress;

    @Embedded
    private WorkerExperience experience;

    @Embedded
    private WorkerFullName fullName;

    @Embedded
    private WorkerPhoneNumber phoneNumber;


    @Embedded
    private WorkerRating rating;

    @Embedded
    private WorkerSkills skills;

    @Embedded
    private WorkerPhoto photo;

    public WorkerProfile(){}

    public WorkerProfile(String firstname, String lastname, String emailAddress,String street, String numberStreet, String district, String postalCode, String city, String country, String area, Double experienceWorking, String countryCode, String number, Double value, String skillName, String descriptionSkill, String photoUrl) {

        this.address = new WorkerAddress( street, numberStreet, district,  postalCode,  city,  country);
        this.emailAddress = new WorkerEmailAddress(emailAddress);
        this.experience = new WorkerExperience(area, experienceWorking);
        this.fullName = new WorkerFullName(firstname, lastname);
        this.phoneNumber = new WorkerPhoneNumber(countryCode, number);
        this.rating = new WorkerRating(value);
        this.skills = new WorkerSkills(skillName, descriptionSkill);
        this.photo=new WorkerPhoto(photoUrl);

    }

    public WorkerProfile(CreateWorkerProfileCommand command){

        this.address = new WorkerAddress( command.street(), command.numberStreet(), command.district(), command.postalCode(), command.city(), command.country());
        this.emailAddress = new WorkerEmailAddress(command.emailAddress());
        this.experience = new WorkerExperience(command.area(), command.experienceWorking());
        this.fullName = new WorkerFullName(command.firstname(), command.lastname());
        this.phoneNumber = new WorkerPhoneNumber(command.countryCode(), command.number());
        this.rating = new WorkerRating(command.value());
        this.skills = new WorkerSkills(command.skillName(), command.descriptionSkill());
        this.photo = new WorkerPhoto(command.photoUrl());

    }

    public String getWorkerAddress() {return address.getWorkerAddress();}

    public String getWorkerEmailAddress() {return emailAddress.address();}

    public String getWorkerExperience(){return experience.getWorkerExperience();}

    public String getWorkerFullName(){return fullName.getWorkerFullName();}

    public String getWorkerPhoneNumber(){return phoneNumber.getWorkerPhoneNumber();}

    public String getWorkerRating(){return rating.getWorkerRating();}

    public String getWorkerSkills(){return skills.getWorkerSkills();}

    public String getWorkerPhoto(){return photo.getWorkerPhoto();}
    

}
