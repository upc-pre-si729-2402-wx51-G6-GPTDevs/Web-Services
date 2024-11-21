package com.tasklinker.tasklinker.profiles.application;

import com.tasklinker.tasklinker.profiles.domain.model.commands.CreateEmployerCommand;
import com.tasklinker.tasklinker.profiles.domain.model.commands.DeleteEmployerByIdCommand;
import com.tasklinker.tasklinker.profiles.domain.model.commands.UpdateEmployerByIdCommand;
import com.tasklinker.tasklinker.profiles.domain.model.entities.Employer;
import com.tasklinker.tasklinker.profiles.domain.model.exceptions.ResourceNotFoundException;
import com.tasklinker.tasklinker.profiles.domain.model.valueobjects.*;
import com.tasklinker.tasklinker.profiles.domain.services.EmployerCommandService;
import com.tasklinker.tasklinker.profiles.infrastructure.persistence.jpa.repositories.EmployerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployerCommandServiceImpl implements EmployerCommandService {

    private final EmployerRepository employerRepository;

    public EmployerCommandServiceImpl(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    @Override
    public Optional<Employer> handle(CreateEmployerCommand command) {

        var employerProfile = new Employer(command);
        var createdEmployerProfile = employerRepository.save(employerProfile);
        return Optional.of(createdEmployerProfile);
    }

    @Override
    public Optional<Employer> handle(UpdateEmployerByIdCommand command) {
        Optional<Employer> existingEmployerOpt = employerRepository.findById(command.id());

        if (existingEmployerOpt.isEmpty()) {
            return Optional.empty();
        }

        Employer existingEmployer = existingEmployerOpt.get();

        FullName updatedFullName = new FullName(command.firstname(), command.lastname());
        CompanyDetails updatedCompanyDetails = new CompanyDetails(command.location(), command.name(), command.numberOfEmployees(), command.website());
        Industry updatedIndustry = new Industry(command.industryName());
        PhoneNumber updatedPhoneNumber = new PhoneNumber(command.countryCode(), command.number());
        Photo updatedPhoto = new Photo(command.photoUrl());
        PaymentMethod updatedPaymentMethod = new PaymentMethod(command.paymentMethod());

        existingEmployer.setFullName(updatedFullName);
        existingEmployer.setCompanyDetails(updatedCompanyDetails);
        existingEmployer.setIndustry(updatedIndustry);
        existingEmployer.setPhoneNumber(updatedPhoneNumber);
        existingEmployer.setPhoto(updatedPhoto);
        existingEmployer.setPaymentMethod(updatedPaymentMethod);

        employerRepository.save(existingEmployer);

        return Optional.of(existingEmployer);
    }

    @Override
    public Optional<Employer> handle(DeleteEmployerByIdCommand command) {
        Optional<Employer> existingEmployerOpt = employerRepository.findById(command.id());

        if (existingEmployerOpt.isPresent()) {
            Employer existingEmployer = existingEmployerOpt.get();
            employerRepository.delete(existingEmployer);
            return Optional.of(existingEmployer);
        } else {
            throw new ResourceNotFoundException("Employer profile with id " + command.id() + " not found.");
        }
    }

}
