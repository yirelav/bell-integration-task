package ru.yirelav.bellintegrationtask.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.Instant;

public record CreateArticleDto(
        @Size(max = 100) String title,
        @Size(max = 64) String author,
        String content,
        @NotNull Instant dateOfPublished
) {
}
