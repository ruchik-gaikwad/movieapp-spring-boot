package com.stackroute.favouriteMovieService.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class SearchResultMovie {


    int id;

    boolean video;

    int vote_count;


    int vote_average;


    String title;


    String release_date;


    String original_language;

}