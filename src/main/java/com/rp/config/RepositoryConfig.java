package com.rp.config;

import com.rp.domain.model.Crew;
import com.rp.domain.model.Movie;
import com.rp.domain.model.Review;
import com.rp.domain.model.User;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;

@Component
public class RepositoryConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Movie.class, Crew.class, User.class, Review.class);
    }
}
