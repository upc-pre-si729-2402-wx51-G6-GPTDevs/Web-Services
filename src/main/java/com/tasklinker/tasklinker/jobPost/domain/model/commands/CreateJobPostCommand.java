package com.tasklinker.tasklinker.jobPost.domain.model.commands;

import java.time.LocalDate;

public record CreateJobPostCommand(
        String title,
        String description,
        String contractType,
        String category,
        String location,
        LocalDate date,
        Double payment) {
}
