package com.tasklinker.tasklinker.profiles.domain.model.valueobjects;

public record WorkerFullName(String firstname, String lastname ) {
    public WorkerFullName(){this(null, null);}

    public String getWorkerFullName(){
        return String.format("%s %s", firstname, lastname);
    }
}
