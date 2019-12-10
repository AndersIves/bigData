package com.cqu.recommendation;

import com.cqu.recommendation.repository.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecommendationApplication {

    @Autowired
    MovieMapper movieMapper;
    public static void main(String[] args) {
        SpringApplication.run(RecommendationApplication.class, args);

    }

}
