package com.rp.domain.repository;

import com.rp.domain.model.Crew;
import com.rp.domain.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface CrewRepository extends PagingAndSortingRepository<Crew, String> {


    @RestResource(path = "byName")
    Page<Crew> findByNameContainingIgnoreCase(String name, Pageable pageable);

    @RestResource(path = "byProfession")
    Page<Crew> findByProfessionContainingIgnoreCase(String profession, Pageable pageable);
}
