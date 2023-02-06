package ru.yirelav.bellintegrationtask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.yirelav.bellintegrationtask.domain.Article;
import ru.yirelav.bellintegrationtask.dto.IArticlePeriodicalStatisticRecord;

import java.time.Instant;
import java.util.Collection;
import java.util.Map;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query(nativeQuery = true, value = "SELECT date_trunc('day', a.date_of_published at time zone 'UTC') AS date, count(a) AS count " +
            "FROM article a " +
            "WHERE a.date_of_published BETWEEN :startDate AND :endDate " +
            "GROUP BY date")
    Collection<IArticlePeriodicalStatisticRecord> findDailyStats(Instant startDate, Instant endDate);

}
