package com.tasklinker.tasklinker.profiles.domain.model.valueobjects;

public record CompanyDetails(String location, String name, int numberOfEmployees, String website) {
    public CompanyDetails() {this(null,null,0,null);}
    public CompanyDetails {
        if (location == null || location.isBlank()) {
            throw new IllegalArgumentException("Location can't be blank");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name can't be blank");
        }
        if (numberOfEmployees < 1) {
            throw new IllegalArgumentException("Company size must be at least 1 employee");
        }
        if (website == null || !website.matches("^https?://.*")) {
            throw new IllegalArgumentException("Invalid URL for company website");
        }
    }

    public String getCompanyDetails() {
        return String.format(
                "Location: %s, Name: %s, Size: %d employees, Website: %s",
                location, name, numberOfEmployees, website
        );
    }
}
