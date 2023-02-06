package ru.yirelav.bellintegrationtask.dto;

import java.time.Instant;

public interface IArticlePeriodicalStatisticRecord {
    Instant getDate();

    Integer getCount();
}
