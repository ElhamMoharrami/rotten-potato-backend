package com.rp.domain.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "crew")
public class Crew {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
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
    @Column(name = "POSTER")
    private String poster;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "movie_crew",
            joinColumns = @JoinColumn(name = "crew_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"))
    private List<Movie> movies;

}
