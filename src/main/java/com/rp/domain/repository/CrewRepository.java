package com.rp.domain.repository;

import com.rp.domain.model.Crew;
import org.springframework.data.jpa.repository.Query;
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

    @RestResource(path = "search")
    @Query("SELECT c FROM Crew c " +
            "where (:name is null or lower(c.name) like lower(concat('%', :name ,'%'))) " +
            "and   (:profession is null or lower(c.profession) like lower(concat('%', :profession, '%'))) " +
            "and   (:birthFrom is null or c.birth >= :birthFrom) " +
            "and   (:birthTo is null or c.birth <= :birthTo) ")
    Page<Crew> search(
            String name,
            String profession,
            String birthFrom,
            String birthTo,
            Pageable pageable);
}
