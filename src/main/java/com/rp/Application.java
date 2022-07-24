package com.rp;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rp.domain.model.Movie;
import com.rp.domain.repository.MovieRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import java.io.File;
import java.util.Arrays;


@SpringBootApplication
@PropertySource("database.properties")
public class Application {

    @Autowired
    private MovieRepository movieRepository;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    InitializingBean sendDatabase() {
        return () -> {
            ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Movie[] movies = mapper.readValue(new File("movies.json"), Movie[].class);
            movieRepository.saveAll(Arrays.asList(movies));
        };
    }
}
