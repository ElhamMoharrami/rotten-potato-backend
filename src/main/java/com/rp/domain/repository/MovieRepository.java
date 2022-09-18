package com.rp.domain.repository;

import com.rp.domain.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

}
