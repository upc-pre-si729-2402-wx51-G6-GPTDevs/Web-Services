package com.tasklinker.tasklinker.profiles.domain.model.valueobjects;

public record Photo(String photoUrl) {
    public Photo(){
        this(null);
    }
    public String getPhoto(){return String.format("%s",photoUrl);}
}
