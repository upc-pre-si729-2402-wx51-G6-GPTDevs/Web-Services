package com.tasklinker.tasklinker.profiles.interfaces.rest.transform;

import com.tasklinker.tasklinker.profiles.domain.model.entities.Employer;
import com.tasklinker.tasklinker.profiles.interfaces.rest.resources.EmployerResource;

public class EmployerResourceFromEntityAssembler {
    public static EmployerResource toResourceFromEntity(Employer entity) {
        return new EmployerResource(
                entity.getId(),
                entity.getFullName().firstname(),
                entity.getFullName().lastname(),
                entity.getCompanyDetails().location(),
                entity.getCompanyDetails().name(),
                entity.getCompanyDetails().numberOfEmployees(),
                entity.getCompanyDetails().website(),
                entity.getIndustry().getIndustryName(),
                entity.getPhoneNumber().countryCode(),
                entity.getPhoneNumber().number(),
                entity.getPhoto().photoUrl(),
                entity.getPaymentMethod().paymentMethod());
    }
}