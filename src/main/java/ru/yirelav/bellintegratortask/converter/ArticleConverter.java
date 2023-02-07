package ru.yirelav.bellintegratortask.converter;

import org.springframework.stereotype.Component;
import ru.yirelav.bellintegratortask.domain.Article;
import ru.yirelav.bellintegratortask.dto.ArticleDto;

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
