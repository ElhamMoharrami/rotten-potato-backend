package com.rp.domain.repository;

import com.rp.domain.model.Movie;
import com.rp.domain.model.Review;
import com.rp.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface ReviewRepository extends PagingAndSortingRepository<Review, String> {

    @RestResource(path = "search")
    @Query("SELECT r FROM Review r " +
            "where (:description is null or lower(r.description) like lower(concat('%', :description, '%'))) " +
            "and   (:user is null or r.user.id like :user) " +
            "and   (:movie is null or r.movie.id like :movie) " +
            "and   (:rateFrom is null or r.rate >= :rateFrom) " +
            "and   (:rateTo is null or r.rate <= :rateTo) ")
    Page<Review> search(
            String user,
            String movie,
            String description,
            Double rateFrom,
            Double rateTo,
            Pageable pageable);
}
