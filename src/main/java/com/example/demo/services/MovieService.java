package com.example.demo.services;

import com.example.demo.dto.MovieRequestDTO;
import com.example.demo.dto.MovieResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.UUID;

@Service
public interface MovieService {

    List<MovieResponseDTO> findAllMovies();

    MovieResponseDTO findMovieById(UUID movieId);

    MovieResponseDTO saveMovie(MovieRequestDTO movieRequestDTO);
}
