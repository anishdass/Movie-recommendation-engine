package com.example.demo.components;

import com.example.demo.configs.TMDBConfig;
import com.example.demo.dto.TMDBResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@RequiredArgsConstructor
public class TMDBClient {
    private final TMDBConfig config;

    private final RestClient restClient = RestClient.create();

    public TMDBResponseDTO getPopularMovies(){
        return restClient.get()
                .uri(
                        config.getUrl()
                        + "/movie/popular?api_key="
                        + config.getKey()
                )
                .retrieve()
                .body(TMDBResponseDTO.class);
    }
}
