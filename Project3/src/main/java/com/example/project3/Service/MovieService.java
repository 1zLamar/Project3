package com.example.project3.Service;

import com.example.project3.ApiException.ApiException;
import com.example.project3.Model.Director;
import com.example.project3.Model.Movie;
import com.example.project3.Repository.DirectorRepository;
import com.example.project3.Repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    private final DirectorRepository directorRepository;

    public List<Movie> getAllMovies(){

        return movieRepository.findAll();
    }

    public void AddMovie(Movie movie){

        movieRepository.save(movie);
    }

    public void updateMovie(Movie movie, Integer id){
        Movie movie1=movieRepository.findMovieById(id);
        if(movie1==null){
            throw new ApiException("not found");
        }
        movie1.setName(movie.getName());
        movie1.setDuration(movie.getDuration());
        movie1.setGenre(movie.getGenre());
        movie1.setRating(movie.getRating());

        movieRepository.save(movie1);
    }

    public void deleteMovie(Integer id){
        Movie movie=movieRepository.findMovieById(id);
        if(movie==null){
            throw new ApiException("not found");
        }
        movieRepository.delete(movie);
    }

    public Movie findMovieByName(String name){
        Movie movie=movieRepository.findMovieByName(name);
        if(movie==null){
            throw new ApiException("not found");
        }
        return movie;
    }

    public Integer findMovieByDuration(String name){
        Movie movie=movieRepository.findMovieByName(name);
        if(movie==null){
            throw new ApiException("not found");
        }
        Integer duration=movie.getDuration();
        return duration;
    }

        public String findDirectorByMovieName(String name){
            Movie movie=movieRepository.findMovieByName(name);
            Integer directorId=movie.getDirectorId();
            if(movie==null){
                throw new ApiException("not found");
            }
            if(directorId==null){
                throw new ApiException("not found");
            }
            Director director=directorRepository.findDirectorById(directorId);
            return director.getName();
        }

    public List<Movie> findMoviesByDirectorName(String directorName){
        Director directors = directorRepository.findDirectorByName(directorName);
        List<Movie> movies=movieRepository.findByDirectorId(directors.getId());
        if(movies==null){
            throw new ApiException("Director not found");
        }
        return movies;
    }
    public Integer findRateByName(String name){
        Movie movie1=movieRepository.findMovieByName(name);
        if(movie1==null){
            throw new ApiException("not found");
        }
        Integer rate=movie1.getRating();
        return rate;
    }

    public List findMoviesByRating(Integer rating){
        List<Movie> movie1=movieRepository.findMoviesByRatingGreaterThan(rating);
        if(movie1==null){
            throw new ApiException("not found");
        }
        return movie1;
    }

    public List findMoviesByGenre(String genre){
        List<Movie> movieList=movieRepository.findMoviesByGenre(genre);
        if(movieList==null){
            throw new ApiException("not found");
        }
        return movieList;
    }
}
