package com.tasklinker.tasklinker.profiles.domain.model.valueobjects;

public record PhoneNumber(String countryCode, String number) {
    public PhoneNumber(){this(null,null);}

    public String getPhoneNumber(){
        return String.format("%s %s", countryCode, number);
    }
}
