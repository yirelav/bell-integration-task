package ru.yirelav.bellintegratortask.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.yirelav.bellintegratortask.converter.ArticleConverter;
import ru.yirelav.bellintegratortask.domain.Article;
import ru.yirelav.bellintegratortask.dto.ArticleDto;
import ru.yirelav.bellintegratortask.dto.CreateArticleDto;
import ru.yirelav.bellintegratortask.dto.IArticlePeriodicalStatisticRecord;
import ru.yirelav.bellintegratortask.dto.PageDto;
import ru.yirelav.bellintegratortask.service.ArticleService;
import ru.yirelav.bellintegratortask.service.ArticleStatisticService;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collection;

@RestController
@RequestMapping("/articles")
@AllArgsConstructor
@Validated
public class ArticleController {

    private final ArticleConverter converter;
    private final ArticleService articleService;
    private final ArticleStatisticService statisticService;

    @GetMapping
    public PageDto<ArticleDto> getArticles(@PageableDefault Pageable pageable) {
        Page<ArticleDto> page = articleService.findPageAndSort(pageable).map(converter::toArticleDto);
        return PageDto.fromPage(page);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ArticleDto createArticle(@Valid @RequestBody CreateArticleDto createArticleDto) {
        Article article = articleService.createArticle(createArticleDto);
        return converter.toArticleDto(article);
    }

    @GetMapping("/stats")
    public Collection<IArticlePeriodicalStatisticRecord> getCount(
            @RequestParam(required = false) Instant startDate,
            @RequestParam(required = false) Instant endDate
    ) {
        if (startDate == null && endDate == null) {
            Instant now = Instant.now();
            startDate = now.minus(7, ChronoUnit.DAYS);
            endDate = now;
        }
        return statisticService.daily(startDate, endDate);
    }

}
