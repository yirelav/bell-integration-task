package ru.yirelav.bellintegrationtask.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yirelav.bellintegrationtask.dto.IArticlePeriodicalStatisticRecord;
import ru.yirelav.bellintegrationtask.repository.ArticleRepository;

import java.time.Instant;
import java.util.Collection;

@Service
@AllArgsConstructor
public class ArticleStatisticService {

    private final ArticleRepository repository;

    public Collection<IArticlePeriodicalStatisticRecord> daily(
            Instant startDate,
            Instant endDate) {
        return repository.findDailyStats(startDate, endDate);
    }

}
