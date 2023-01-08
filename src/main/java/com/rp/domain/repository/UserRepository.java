package com.rp.domain.repository;

import com.rp.domain.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface UserRepository extends PagingAndSortingRepository<User, String> {
    @RestResource(path = "byUsername")
    User findByUsername(String username);
}
