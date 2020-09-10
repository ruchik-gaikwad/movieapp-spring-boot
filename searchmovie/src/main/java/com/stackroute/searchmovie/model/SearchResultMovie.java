package com.stackroute.searchmovie.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "movies")
@AllArgsConstructor
@NoArgsConstructor
public class SearchResultMovie {

       @Id
       @Column
       int id;

       @Column
       boolean video;

       @Column
       int vote_count;

       @Column
       int vote_average;

       @Column
       String title;

       @Column
       String release_date;

       @Column
       String original_language;

}
