package ru.yirelav.bellintegrationtask.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.yirelav.bellintegrationtask.domain.Article;
import ru.yirelav.bellintegrationtask.dto.CreateArticleDto;
import ru.yirelav.bellintegrationtask.repository.ArticleRepository;

@Service
@AllArgsConstructor
public class ArticleService {

    private final ArticleRepository repository;

    public Article createArticle(CreateArticleDto createArticleDto) {
        return repository.save(
                Article.builder()
                .title(createArticleDto.title())
                .content(createArticleDto.content())
                .author(createArticleDto.author())
                .dateOfPublished(createArticleDto.dateOfPublished())
                .build()
        );
    }

    public Page<Article> findPageAndSort(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
