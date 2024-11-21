package com.tasklinker.tasklinker.profiles.domain.model.valueobjects;

public record FullName(String firstname, String lastname ) {
    public FullName(){this(null, null);}

    public String getFullName(){
        return String.format("%s %s", firstname, lastname);
    }
}
