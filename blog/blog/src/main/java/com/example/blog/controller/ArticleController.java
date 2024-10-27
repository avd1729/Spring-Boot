package com.example.blog.controller;

import com.example.blog.model.Article;
import com.example.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ArticleController {

    @Autowired
    private ArticleService service;

    @GetMapping("/article")
    public ResponseEntity<List<Article>> getAllArticles() {
        return new ResponseEntity<>(service.getAllArticles(), HttpStatus.OK);
    }

    @GetMapping("/article/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable int id) {
        Article article = service.getArticleById(id);
        if (article != null) {
            return new ResponseEntity<>(article, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/article")
    public ResponseEntity<?> addArticle(@RequestBody Article article) {

        try {
            Article article1 = service.addArticle(article);
            return new ResponseEntity<>(article1, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/article/{id}")
    public ResponseEntity<?> updateArticle(@PathVariable int id, @RequestBody Article article) {
        Article article1 = service.updateArticle(id, article);

        if (article1 != null) {
            return new ResponseEntity<>(article1, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
