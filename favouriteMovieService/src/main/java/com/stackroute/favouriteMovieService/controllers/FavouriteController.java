package com.stackroute.favouriteMovieService.controllers;

import com.stackroute.favouriteMovieService.configurations.KafkaConfiguration;
import com.stackroute.favouriteMovieService.model.SearchResultMovie;
import com.stackroute.favouriteMovieService.service.FavouriteMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;

@Controller
public class FavouriteController {

    FavouriteMovieService service;

    @Autowired
    FavouriteController (FavouriteMovieService service) {
        this.service = service;
    }

    @KafkaListener(topics = "favourite_movie", groupId = "groupp_Id")
    public void consume(SearchResultMovie movie) {
        System.out.println(movie.toString());
        this.service.saveFavouriteMovie(movie);
    }
}
