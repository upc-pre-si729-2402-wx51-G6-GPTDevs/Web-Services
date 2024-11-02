package com.tasklinker.tasklinker.profiles.domain.model.commands;



public record CreateWorkerProfileCommand (String firstname, String lastname, String emailAddress, String street, String numberStreet, String district, String postalCode, String city, String country, String area, Double experienceWorking, String countryCode, String number, Double value, String skillName, String descriptionSkill,  String photoUrl) {

}
