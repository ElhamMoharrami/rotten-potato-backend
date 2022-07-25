package com.rp;

import com.rp.domain.repository.MovieRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@PropertySource("database.properties")
public class Application {

    private final MovieRepository movieRepository;

    public Application(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
    }
}
