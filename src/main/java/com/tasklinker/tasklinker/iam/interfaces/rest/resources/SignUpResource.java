package com.tasklinker.tasklinker.iam.interfaces.rest.resources;

public record SignUpResource(String email, String password, String cardNumber,
        String expirementDate, String securityCode) {

}
