package com.example.demo.services;

import com.example.demo.dto.MovieRequestDTO;
import com.example.demo.dto.MovieResponseDTO;
import com.example.demo.exceptions.MovieNotFoundException;
import com.example.demo.models.Movie;
import com.example.demo.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepository;

    public List<MovieResponseDTO> findAllMovies(){
        return movieRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public MovieResponseDTO findMovieById(UUID movieId){
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(()-> new MovieNotFoundException("Movie not found"));

        return mapToResponse(movie);
    }

    public MovieResponseDTO saveMovie(MovieRequestDTO movieRequestDTO){

        Movie movie = Movie.builder()
                .title(movieRequestDTO.title())
                .genre(movieRequestDTO.genre())
                .rating(movieRequestDTO.rating())
                .releaseYear(movieRequestDTO.releaseYear())
                .build();

        Movie savedMovie=movieRepository.save(movie);

        return mapToResponse(savedMovie);
    }

    private MovieResponseDTO mapToResponse(Movie savedMovie){
        return new MovieResponseDTO(
                savedMovie.getId(),
                savedMovie.getTitle(),
                savedMovie.getGenre(),
                savedMovie.getRating(),
                savedMovie.getReleaseYear()
        );
    }

}
