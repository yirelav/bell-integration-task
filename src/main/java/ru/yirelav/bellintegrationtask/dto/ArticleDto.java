package ru.yirelav.bellintegrationtask.dto;

import lombok.Builder;
import lombok.Value;

import java.time.Instant;

@Builder
@Value
public class ArticleDto {

    String title;

    String author;

    String content;

    Instant dateOfPublished;

}
