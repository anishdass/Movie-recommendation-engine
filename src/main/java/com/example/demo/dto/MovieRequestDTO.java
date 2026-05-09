package com.example.demo.dto;

import jakarta.validation.constraints.*;

public record MovieRequestDTO(
        @NotBlank(message = "Title is required")
        String title,

        @NotBlank(message = "Genre is required")
        String genre,

        @DecimalMin(value = "0.5")
        @DecimalMax(value = "5")
        @Pattern(regexp = "^[0-5](\\.0|\\.5)?$", message = "Rating must be in increments of 0.5 (e.g., 1.0, 1.5, 2.0)")
        Double rating,

        @Min(value = 1900)
        Integer releaseYear
) {
}
