package com.rp.domain.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "ID")
    private String id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "YEAR")
    private String year;
    @Column(name = "RATED")
    private String rated;
    @Column(name = "RELEASED")
    private String released;
    @Column(name = "RUNTIME")
    private String runtime;
    @Column(name = "GENRE")
    private String genre;
    @Column(name = "DIRECTOR")
    private String director;
    @Column(name = "WRITER")
    private String writer;
    @Column(name = "ACTORS")
    private String actors;
    @Column(name = "PLOT")
    private String plot;
    @Column(name = "LANGUAGE")
    private String language;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "AWARDS")
    private String awards;
    @Column(name = "POSTER")
    private String poster;
    @Column(name = "META_SCORE")
    private String metaScore;
    @Column(name = "IMDB_RATING")
    private Double imdbRating;
    @Column(name = "IMDB_VOTES")
    private String imdbVotes;
    @Column(name = "TYPE")
    private String type;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "movie_crew",
            joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "crew_id", referencedColumnName = "id"))
    private List<Crew> crews;

}
