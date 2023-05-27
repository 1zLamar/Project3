package com.example.project3.Controller;

import com.example.project3.Model.Director;
import com.example.project3.Model.Movie;
import com.example.project3.Service.DirectorService;
import com.example.project3.Service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/director")
@RequiredArgsConstructor
public class DirectorController {

    private final DirectorService directorService;

    @GetMapping("/get")
    public ResponseEntity getAllDirector() {
        List<Director> movieList = directorService.getAllDirectors();
        return ResponseEntity.status(200).body(movieList);
    }

    @PostMapping("/add")
    public ResponseEntity addDirector(@Valid @RequestBody Director director) {
        directorService.AddDirector(director);
        return ResponseEntity.status(200).body("Director added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBlog(@Valid @RequestBody Director director, @PathVariable Integer id) {
        directorService.updateDirector(director, id);
        return ResponseEntity.status(200).body("Director updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBlog(@PathVariable Integer id) {
        directorService.deleteDirector(id);
        return ResponseEntity.status(200).body("Director deleted");
    }

}
