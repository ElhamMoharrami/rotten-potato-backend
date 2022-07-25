package com.rp.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "crew")
public class Crew {
    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "BIRTH")
    private String birth;
    @Column(name = "DEATH")
    private String death;
    @Column(name = "PROFESSION")
    private String profession;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "movie_crew",
            joinColumns = @JoinColumn(name = "crew_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"))
    private List<Movie> movies;

}
