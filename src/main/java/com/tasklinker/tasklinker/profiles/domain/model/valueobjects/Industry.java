package com.tasklinker.tasklinker.profiles.domain.model.valueobjects;

public record Industry(String industryName) {
    public Industry(){this(null);}
    public Industry {
        if (industryName == null || industryName.isBlank()) {
            throw new IllegalArgumentException("Industry name cannot be empty");
        }
    }
    public String getIndustryName(){
        return String.format("%s",industryName);
    }
}
