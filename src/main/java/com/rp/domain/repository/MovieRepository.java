package com.rp.domain.repository;

import com.rp.domain.model.Movie;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface MovieRepository extends PagingAndSortingRepository<Movie, String> {
}
