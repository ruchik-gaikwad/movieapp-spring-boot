package com.stackroute.searchmovie.controllers;


import com.stackroute.searchmovie.model.SearchResultMovie;
import com.stackroute.searchmovie.services.FavouriteService;
import com.stackroute.searchmovie.services.SearchMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import javax.persistence.PostLoad;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/public/api/v1/movie")
public class SearchMovieController {
    SearchMovieService service;
    FavouriteService favService;
    KafkaTemplate kafkaTemplate;

    @Autowired
    SearchMovieController(SearchMovieService service, FavouriteService favService, KafkaTemplate kafkaTemplate) {
            this.service = service;
            this.favService = favService;
            this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/ping")
    public ResponseEntity<?> ping(){
        return new ResponseEntity<String>("This is working !!!",HttpStatus.OK);
    }

    @GetMapping("/search/{movieName}")
    public ResponseEntity<List> searchMovie(@PathVariable String movieName) throws IOException {
        System.out.println(movieName);
        List<SearchResultMovie> result =  service.searchMovie("pk");
        return new ResponseEntity<List>(result, HttpStatus.OK);
    }

    @PostMapping("/favourite")
    public ResponseEntity<?> addMovieToFavourites(@RequestBody SearchResultMovie movie) {
        System.out.println(movie);
        kafkaTemplate.send("favourite_movie", movie);
        return new ResponseEntity<SearchResultMovie>(favService.saveFavouriteMovie(movie), HttpStatus.CREATED);

    }

    @GetMapping("/favourite")
    public  ResponseEntity<?> getAllFavouriteMovie() {
        return new ResponseEntity<Iterable<SearchResultMovie>>(favService.getAllFavourite(), HttpStatus.OK);
    }
}
