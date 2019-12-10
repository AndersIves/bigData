package com.cqu.recommendation.controller;

import com.cqu.recommendation.repository.MovieMapper;
import com.cqu.recommendation.repository.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Autowired
    MovieMapper movieMapper;
    @RequestMapping("/")
    String home() {
        Movie movie = new Movie();
        movie.setMid(1L);
        movie.setTitle("setTitle");
        movie.setGenres("setGenres");
        movieMapper.save(movie);

        System.out.println(movieMapper.findAll());
        return "hello";
    }
}
