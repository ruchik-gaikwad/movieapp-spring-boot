package com.stackroute.searchmovie.dao;

import com.stackroute.searchmovie.model.SearchResultMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface FavouriteDao extends CrudRepository<SearchResultMovie, Integer> {

}
