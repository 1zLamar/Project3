package com.example.project3.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name shouldn't be null")
    @Size(min = 2, message = "Name must be at least 3 characters")
    private String name;

    @NotEmpty(message = "genre shouldn't be null")
    @Pattern(regexp = "^(drama|action|comedy)$", message = "Genre must be Drama, Action or Comedy")
    private String genre;

    @NotNull(message = "rating shouldn't be null")
    @Min(value = 1, message = "Rating must be between 1 and 5")
    @Max(value = 5, message = "Rating must be between 1 and 5")
    private Integer rating;

    @NotNull(message = "Duration shouldn't be null")
    @Min(value = 60, message = "Duration must be at least 60")
    private Integer duration;

    @NotNull(message = "Duration shouldn't be null")
    private Integer directorId;

}
