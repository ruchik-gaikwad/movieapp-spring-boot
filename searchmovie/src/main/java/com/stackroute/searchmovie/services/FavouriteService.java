package com.stackroute.searchmovie.services;

import com.stackroute.searchmovie.dao.FavouriteDao;
import com.stackroute.searchmovie.model.SearchResultMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FavouriteService {

    @Autowired
    private FavouriteDao fav;

    public void findFavouriteMovie(int Id) {
       Optional<SearchResultMovie> movie =  fav.findById(Id);
        System.out.println(movie);
    }

    public SearchResultMovie saveFavouriteMovie(SearchResultMovie movie) {
        SearchResultMovie saved = fav.save(movie);
        return saved;
    }

    public Iterable<SearchResultMovie> getAllFavourite() {
        return fav.findAll();
    }
}
