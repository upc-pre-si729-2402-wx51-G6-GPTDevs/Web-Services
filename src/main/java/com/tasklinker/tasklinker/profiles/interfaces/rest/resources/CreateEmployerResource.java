package com.tasklinker.tasklinker.profiles.interfaces.rest.resources;

public record CreateEmployerResource(String firstname, String lastname, String location, String name, int numberOfEmployees, String website,String industryName,String countryCode, String number,String photoUrl,String paymentMethod) {
}