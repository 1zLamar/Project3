package com.example.project3.Controller;

import com.example.project3.Model.Movie;
import com.example.project3.Service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/get")
    public ResponseEntity getAllmovies() {
        List<Movie> movieList = movieService.getAllMovies();
        return ResponseEntity.status(200).body(movieList);
    }

    @PostMapping("/add")
    public ResponseEntity addMovie(@Valid @RequestBody Movie movie) {
        movieService.AddMovie(movie);
        return ResponseEntity.status(200).body("Movie added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBlog(@Valid @RequestBody Movie movie, @PathVariable Integer id) {
        movieService.updateMovie(movie, id);
        return ResponseEntity.status(200).body("Movie updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBlog(@PathVariable Integer id) {
        movieService.deleteMovie(id);
        return ResponseEntity.status(200).body("Movie deleted");
    }
    @GetMapping("/get-name/{name}")
    public ResponseEntity findMovieByName(@PathVariable String name){
        Movie movie=movieService.findMovieByName(name);
        return ResponseEntity.status(200).body(movie);
    }
    @GetMapping("/get-duration/{name}")
    public ResponseEntity findMovieByDuration(@PathVariable String name){
        Integer movie=movieService.findMovieByDuration(name);
        return ResponseEntity.status(200).body(movie);
    }

    @GetMapping("/get-director/{name}")
    public ResponseEntity findDirectorByMovieName(@PathVariable String name){
        String movieDirector=movieService.findDirectorByMovieName(name);
        return ResponseEntity.status(200).body(movieDirector);
    }

    @GetMapping("/get-movies/{name}")
    public ResponseEntity findMoviesByDirectorName(@PathVariable String name){
        List<Movie> movieList=movieService.findMoviesByDirectorName(name);
        return ResponseEntity.status(200).body(movieList);
    }

    @GetMapping("/get-rate/{name}")
    public ResponseEntity findRateByName(@PathVariable String name){
        Integer movie=movieService.findRateByName(name);
        return ResponseEntity.status(200).body(movie);
    }
    @GetMapping("/get-moviesRate/{rate}")
    public ResponseEntity findMoviesByRating(@PathVariable Integer rate){
        List<Movie> movieList=movieService.findMoviesByRating(rate);
        return ResponseEntity.status(200).body(movieList);
    }
    @GetMapping("/get-genre/{genre}")
    public ResponseEntity findMoviesByGenre(@PathVariable String genre){
        List<Movie> movieList=movieService.findMoviesByGenre(genre);
        return ResponseEntity.status(200).body(movieList);
    }

}

