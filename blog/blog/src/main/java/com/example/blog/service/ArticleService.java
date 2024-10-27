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
}
