package com.back.sbb.article;

import com.back.sbb.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public List<Article> getList() {
        return articleRepository.findAll();
    }

    public Article get(Long id) {
        return articleRepository.findById(id).orElseThrow();
    }

    public void create(String title, String content, SiteUser author) {
        Article article = new Article();

        article.setTitle(title);
        article.setContent(content);
        article.setCreatedDate(LocalDateTime.now());
        article.setAuthor(author);

        articleRepository.save(article);
    }

    public void modify(Article article, String title, String content) {

        article.setTitle(title);
        article.setContent(content);

        articleRepository.save(article);
    }

    public void delete(Article article) {
        articleRepository.delete(article);
    }
}