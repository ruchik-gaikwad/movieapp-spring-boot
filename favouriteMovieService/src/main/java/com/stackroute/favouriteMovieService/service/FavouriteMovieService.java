package com.stackroute.favouriteMovieService.service;

import com.stackroute.favouriteMovieService.dao.Favouritedao;
import com.stackroute.favouriteMovieService.model.SearchResultMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavouriteMovieService {

    Favouritedao dao;

    @Autowired
    FavouriteMovieService(Favouritedao dao) {
        this.dao = dao;
    }

    public SearchResultMovie saveFavouriteMovie(SearchResultMovie movie) {
        SearchResultMovie savedMovie  = dao.save(movie);
        return savedMovie;
    }

}
