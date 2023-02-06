package ru.yirelav.bellintegrationtask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yirelav.bellintegrationtask.domain.Article;
import ru.yirelav.bellintegrationtask.repository.ArticleRepository;

import java.util.ArrayList;
import java.util.List;

import static ru.yirelav.bellintegrationtask.config.TestConstants.*;

@Component
public class EntityCreator {

    @Autowired
    ArticleRepository articleRepository;

    public Article createArticle() {
        return articleRepository.save(
                createArticleEntity()
        );
    }

    public List<Article> createNArticles(int n) {
        List<Article> articles = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            articles.add(createArticleEntity());
        }
        return articleRepository.saveAll(articles);
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
