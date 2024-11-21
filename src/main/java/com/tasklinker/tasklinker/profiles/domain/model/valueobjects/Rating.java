package com.tasklinker.tasklinker.profiles.domain.model.valueobjects;

public record Rating(Double value) {
    public Rating(){this(null);}
    public Rating {
        if (value < 0 || value > 5){
            throw new IllegalArgumentException("Rating value must be between 0 and 5.");
        }
    }

    public String getRating() {
        return String.format("Worker rating: %.1f / 5", value);
    }
}
