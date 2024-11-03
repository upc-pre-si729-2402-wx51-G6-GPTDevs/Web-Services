package com.tasklinker.tasklinker.profiles.interfaces.rest.resources;


public record CreateWorkerResource(String firstname, String lastname, String emailAddress, String street, String numberStreet, String district, String postalCode, String city, String country, String area, Double experienceWorking, String countryCode, String number, Double value, String skillName, String descriptionSkill, String photoUrl) {

}
