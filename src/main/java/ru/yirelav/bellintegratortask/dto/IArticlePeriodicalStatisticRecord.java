package ru.yirelav.bellintegratortask.dto;

import java.time.Instant;

public interface IArticlePeriodicalStatisticRecord {
    Instant getDate();

    Integer getCount();
}
