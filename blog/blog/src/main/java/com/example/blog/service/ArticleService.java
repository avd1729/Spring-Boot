package com.example.blog.service;

import com.example.blog.model.Article;
import com.example.blog.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository repository;

    public List<Article> getAllArticles() {
        return repository.findAll();
    }

    public Article getArticleById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Article addArticle(Article article) {
        return repository.save(article);
    }

    public Article updateArticleById(int id, Article article) {
        Article article1 = repository.findById(id).orElse(null);
        if(article1 != null) {
            article1.setTitle(article.getTitle());
            article1.setAuthor(article.getAuthor());
            article1.setContent(article.getContent());
            article1.setPublishedDate(article.getPublishedDate());
            return repository.save(article1);
        } else {
            return repository.save(article);
        }
    }

    public void deleteArticleById(int id) {
        repository.deleteById(id);
    }
}
