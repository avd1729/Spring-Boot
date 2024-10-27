package com.example.blog.controller;

import com.example.blog.model.Article;
import com.example.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ArticleController {

    @Autowired
    private ArticleService service;

    @RequestMapping("/")
    public String greet() {
        return "Hello World";
    }

    @RequestMapping("/articles")
    public List<Article> getAllArticles() {
        return service.getAllArticles();
    }

}
