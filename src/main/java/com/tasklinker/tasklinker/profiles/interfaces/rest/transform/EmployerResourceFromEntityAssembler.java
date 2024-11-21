package com.tasklinker.tasklinker.profiles.interfaces.rest.transform;

import com.tasklinker.tasklinker.profiles.domain.model.entities.Employer;
import com.tasklinker.tasklinker.profiles.interfaces.rest.resources.EmployerResource;

public class EmployerResourceFromEntityAssembler {
    public static EmployerResource toResourceFromEntity(Employer entity) {
        return new EmployerResource(
                entity.getId(),
                entity.getFullName(),
                entity.getCompanyDetails(),
                entity.getPhoneNumber(),
                entity.getPhoto(),
                entity.getPaymentMethod()
        );
    }
}
