package com.stackroute.searchmovie.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchMovieRequestCall {
    private int page;
    int total_results;
    int total_pages;

    @JsonProperty("results")
    List<SearchResultMovie> results;
}
