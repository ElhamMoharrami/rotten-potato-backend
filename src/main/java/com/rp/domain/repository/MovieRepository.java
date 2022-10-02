package com.rp.domain.repository;

import com.rp.domain.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface MovieRepository extends PagingAndSortingRepository<Movie, String> {

    @RestResource(path = "byTitle")
    Page<Movie> findByTitleContainingIgnoreCase(String title, Pageable pageable);

    @RestResource(path = "byYear")
    Page<Movie> findByYearBetween(String from, String to, Pageable pageable);

    @RestResource(path = "search")
    @Query("SELECT m FROM Movie m " +
            "where (:title is null or lower(m.title) like lower(concat('%', :title, '%'))) " +
            "and   (:minRate is null or m.imdbRating >= :minRate) " +
            "and   (:genre is null or lower(m.genre) like lower(concat('%', :genre, '%'))) " +
            "and   (:yearFrom is null or m.year >= :yearFrom) " +
            "and   (:yearTo is null or m.year <= :yearTo) ")
    Page<Movie> search(
            String title,
            Double minRate,
            String genre,
            String yearFrom,
            String yearTo,
            Pageable pageable);
}
