package ru.yirelav.bellintegrationtask.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.yirelav.bellintegrationtask.converter.ArticleConverter;
import ru.yirelav.bellintegrationtask.domain.Article;
import ru.yirelav.bellintegrationtask.dto.ArticleDto;
import ru.yirelav.bellintegrationtask.dto.CreateArticleDto;
import ru.yirelav.bellintegrationtask.dto.PageDto;
import ru.yirelav.bellintegrationtask.service.ArticleService;

@RestController
@RequestMapping("/articles")
@Validated
public class ArticleController {

    @Autowired
    ArticleConverter converter;

    @Autowired
    private ArticleService articleService;

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
}
