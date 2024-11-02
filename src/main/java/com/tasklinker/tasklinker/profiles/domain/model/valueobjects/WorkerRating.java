package com.tasklinker.tasklinker.profiles.domain.model.valueobjects;

public record WorkerRating(Double value) {
    public WorkerRating(){this(null);}
    public WorkerRating{
        if (value < 0 || value > 5){
            throw new IllegalArgumentException("Rating value must be between 0 and 5.");
        }
    }

    public String getWorkerRating() {
        return String.format("Worker rating: %.1f / 5", value);
    }
}
