package ru.yirelav.bellintegratortask.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yirelav.bellintegratortask.dto.IArticlePeriodicalStatisticRecord;
import ru.yirelav.bellintegratortask.repository.ArticleRepository;

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
