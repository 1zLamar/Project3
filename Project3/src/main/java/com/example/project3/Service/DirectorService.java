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
public class DirectorService {

    private final DirectorRepository directorRepository;

    public List<Director> getAllDirectors(){

        return directorRepository.findAll();
    }

    public void AddDirector(Director director){

        directorRepository.save(director);
    }

    public void updateDirector(Director director, Integer id){
        Director director1=directorRepository.findDirectorById(id);
        if(director1==null){
            throw new ApiException("not found");
        }
        director1.setName(director.getName());

        directorRepository.save(director1);
    }

    public void deleteDirector(Integer id){
        Director director=directorRepository.findDirectorById(id);
        if(director==null){
            throw new ApiException("not found");
        }
        directorRepository.delete(director);
    }







}
