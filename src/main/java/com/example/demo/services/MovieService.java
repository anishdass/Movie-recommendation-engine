package com.example.demo.services;

import com.example.demo.models.Movie;
import com.example.demo.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<Movie> findAllMovies(){
        return movieRepository.findAll();
    }

    public Movie saveMovie(Movie movie){
        return movieRepository.save(movie);
    }
}
