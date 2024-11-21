package com.tasklinker.tasklinker.profiles.domain.model.valueobjects;

public record Experience(String area, Double experienceWorking) {
    public Experience() {
        this(null,null);
    }

    public Experience(String area, Double experienceWorking) {
        this.area = area; this.experienceWorking=experienceWorking;
    }

    public String getExperience() {
        return String.format("Professional Area: %s, Years Working: %f",
                area != null && !area.isBlank() ? area : "unspecified area", experienceWorking);
    }
}
