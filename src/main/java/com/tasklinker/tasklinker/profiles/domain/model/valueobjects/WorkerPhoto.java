package com.tasklinker.tasklinker.profiles.domain.model.valueobjects;

public record WorkerPhoto(String photoUrl) {
    public WorkerPhoto(){
        this(null);
    }
    public String getWorkerPhoto(){return String.format("%s",photoUrl);}
}
