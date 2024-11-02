package com.tasklinker.tasklinker.iam.interfaces.rest.resources;

public record SignUpResource(String name, String email, String password, String phoneNumber, String cardNumber,
                String expirementDate, String securityCode) {

}
