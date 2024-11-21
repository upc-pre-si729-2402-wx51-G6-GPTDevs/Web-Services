package com.tasklinker.tasklinker.jobPost.domain.model.queries;

import java.time.LocalDate;

public record FindJobPostQuery(
                String title,
                String category,
                String location,
                LocalDate startDate,
                LocalDate endDate) {
}
