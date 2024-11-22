package com.tasklinker.tasklinker.profiles.interfaces.rest.resources;

public record WorkerProfileResource(Long id, String address, String emailAddress, String experience, String fullName,
        String phoneNumber, String rating, String skills, String photo) {

}
