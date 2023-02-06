package ru.yirelav.bellintegrationtask.converter;

import org.springframework.stereotype.Component;
import ru.yirelav.bellintegrationtask.domain.Article;
import ru.yirelav.bellintegrationtask.dto.ArticleDto;

@Component
public class ArticleConverter {

    public ArticleDto toArticleDto(Article article) {
        return ArticleDto.builder()
                .title(article.getTitle())
                .content(article.getContent())
                .author(article.getAuthor())
                .dateOfPublished(article.getDateOfPublished())
                .build();
    }

}
