package com.tasklinker.tasklinker.profiles.domain.model.entities;

import com.tasklinker.tasklinker.profiles.domain.model.commands.CreateEmployerCommand;
import com.tasklinker.tasklinker.profiles.domain.model.valueobjects.*;
import com.tasklinker.tasklinker.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employer extends AuditableAbstractAggregateRoot<Employer> {
    @Embedded
    private FullName fullName; //2
    @Embedded
    private CompanyDetails companyDetails; //4
    @Embedded
    private Industry industry; //1
    @Embedded
    private PhoneNumber phoneNumber; //2
    @Embedded
    private Photo photo; //1
    @Embedded
    private PaymentMethod paymentMethod; //1

    public Employer() {}

    public Employer(String firstname, String lastname, String location, String name, int numberOfEmployees, String website,String industryName,String countryCode, String number,String photoUrl,String paymentMethod) {
        this.fullName = new FullName(firstname, lastname);
        this.companyDetails = new CompanyDetails( location,  name,  numberOfEmployees,  website);
        this.industry = new Industry(industryName);
        this.phoneNumber = new PhoneNumber(countryCode, number);
        this.photo = new Photo(photoUrl);
        this.paymentMethod = new PaymentMethod(paymentMethod);
    }

    public Employer(CreateEmployerCommand command) {
        this.fullName = new FullName(command.firstname(), command.lastname());
        this.companyDetails = new CompanyDetails(command.location(), command.name(), command.numberOfEmployees(), command.website());
        this.industry = new Industry(command.industryName());
        this.phoneNumber = new PhoneNumber(command.countryCode(), command.number());
        this.photo = new Photo(command.photoUrl());
        this.paymentMethod = new PaymentMethod(command.paymentMethod());
    }

    public FullName getFullName() {
        return fullName;
    }

    public CompanyDetails getCompanyDetails(){
        return companyDetails;
    }

    public Industry getIndustry() {
        return industry;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public Photo getPhoto() {
        return photo;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

}
