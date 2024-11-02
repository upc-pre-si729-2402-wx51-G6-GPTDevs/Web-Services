package com.tasklinker.tasklinker.profiles.domain.model.valueobjects;

public record WorkerExperience(String area, Double experienceWorking) {
    public WorkerExperience() {
        this(null,null);
    }

    public WorkerExperience(String area, Double experienceWorking) {
        this.area = area; this.experienceWorking=experienceWorking;
    }

    public String getWorkerExperience() {
        return String.format("Professional Area: %s, Years Working: %f",
                area != null && !area.isBlank() ? area : "unspecified area", experienceWorking);
    }
}
