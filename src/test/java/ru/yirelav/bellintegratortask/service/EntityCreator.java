package ru.yirelav.bellintegratortask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yirelav.bellintegratortask.domain.Article;
import ru.yirelav.bellintegratortask.repository.ArticleRepository;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static ru.yirelav.bellintegratortask.config.TestConstants.ARTICLE_AUTHOR;
import static ru.yirelav.bellintegratortask.config.TestConstants.ARTICLE_CONTENT;
import static ru.yirelav.bellintegratortask.config.TestConstants.ARTICLE_DATE_OF_PUBLISHED;
import static ru.yirelav.bellintegratortask.config.TestConstants.ARTICLE_TITLE;

@Component
public class EntityCreator {

    @Autowired
    ArticleRepository articleRepository;

    public void createNArticles(int n) {
        List<Article> articles = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            articles.add(createArticleEntity());
        }
        articleRepository.saveAll(articles);
    }

    public void createNArticlesWithDateOfPublished(int n, Instant date) {
        List<Article> articles = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            Article article = Article.builder()
                    .title(ARTICLE_TITLE)
                    .author(ARTICLE_AUTHOR)
                    .content(ARTICLE_CONTENT)
                    .dateOfPublished(date)
                    .build();
            articles.add(article);
        }
        articleRepository.saveAll(articles);
    }


    private Article createArticleEntity() {
        return Article.builder()
                .title(ARTICLE_TITLE)
                .author(ARTICLE_AUTHOR)
                .content(ARTICLE_CONTENT)
                .dateOfPublished(ARTICLE_DATE_OF_PUBLISHED)
                .build();
    }

}
