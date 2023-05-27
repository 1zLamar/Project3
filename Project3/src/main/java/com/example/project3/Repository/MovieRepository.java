package com.example.project3.Repository;

import com.example.project3.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    Movie findMovieById(Integer id);

    Movie findMovieByName(String name);

    List<Movie> findMoviesByRatingGreaterThan(Integer rating);

    List<Movie> findMoviesByGenre(String genre);

    List<Movie> findByDirectorId(Integer directorId);

}
