package ru.yirelav.bellintegrationtask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yirelav.bellintegrationtask.domain.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

}
