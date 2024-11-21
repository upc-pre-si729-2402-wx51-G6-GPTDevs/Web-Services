package com.tasklinker.tasklinker.profiles.domain.model.commands;

public record CreateEmployerCommand (String firstname, String lastname, String location, String name, int numberOfEmployees, String website,String industryName,String countryCode, String number,String photoUrl,String paymentMethod){

}
