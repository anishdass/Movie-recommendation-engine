package com.example.demo.controllers;

import com.example.demo.services.MovieService;
import com.example.demo.models.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/movies")
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(movieService.findAllMovies());
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(movieService.saveMovie(movie));
    }

}
