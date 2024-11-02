package com.tasklinker.tasklinker.profiles.domain.model.valueobjects;

public record WorkerPhoneNumber(String countryCode, String number) {
    public WorkerPhoneNumber(){this(null,null);}

    public String getWorkerPhoneNumber(){
        return String.format("%s %s", countryCode, number);
    }
}
