package com.tasklinker.tasklinker.jobPost.interfaces.rest.resources;

import java.time.LocalDate;

public record JobPostResource(
        String title,
        String description,
        String contractType,
        String category,
        String location,
        LocalDate date,
        Double payment) {

}
