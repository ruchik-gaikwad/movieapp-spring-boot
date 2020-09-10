package com.stackroute.searchmovie.services;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.searchmovie.model.SearchMovieRequestCall;
import com.stackroute.searchmovie.model.SearchResultMovie;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class SearchMovieService {

    public List<SearchResultMovie> searchMovie(String movieName) throws IOException {

        String url = "https://api.themoviedb.org/3/search/movie?api_key=46cb0826bc9d924445bc90903e183ebf&language=en-US&query=pk&page=1&include_adult=false";

        RestTemplate restTemplate = new RestTemplate();

        SearchMovieRequestCall e =restTemplate.getForObject(url, SearchMovieRequestCall.class);


        List<SearchResultMovie> allMovies = e.getResults();

        return allMovies;


    }
}
