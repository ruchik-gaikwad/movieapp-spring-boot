package com.stackroute.favouriteMovieService.dao;

import com.stackroute.favouriteMovieService.model.SearchResultMovie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Favouritedao extends MongoRepository<SearchResultMovie, Integer> {
}
