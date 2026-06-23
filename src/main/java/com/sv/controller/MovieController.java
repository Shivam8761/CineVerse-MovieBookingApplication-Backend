package com.sv.controller;

import com.sv.DTO.MovieDTO;
import com.sv.entity.Movie;
import com.sv.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
@Tag(name = "Movie Management", description = "APIs for managing movies and retrieving movie information")
public class MovieController {

    @Autowired
   private MovieService movieService;

    @PostMapping("/addmovie")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Movie> addMovie(@RequestBody MovieDTO movieDTO){
        return  ResponseEntity.ok(movieService.addMovie(movieDTO));
    }

    @GetMapping("/getallmovies")
    public ResponseEntity<List<Movie>> getAllMovie(){
        return ResponseEntity.ok(movieService.getAllMovie());
    }

    @GetMapping("/getmoviesbygenre")
    public ResponseEntity<List<Movie>> getMovieByGenre(@RequestParam String genre){
        return ResponseEntity.ok(movieService.getMovieByGenre(genre));
    }

    @GetMapping("/getmoviesbylanguage")
    public ResponseEntity<List<Movie>> getMovieByLanguage(@RequestParam String language){
        return ResponseEntity.ok(movieService.getMovieByLanguage(language));
    }

    @GetMapping("/getmoviesbytitle")
    public  ResponseEntity<Movie> getMovieByTitle(@RequestParam String title){
        return  ResponseEntity.ok(movieService.getMovieByTitle(title));
    }

    @PutMapping("/updatemovie/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody MovieDTO movieDTO){
        return ResponseEntity.ok(movieService.updateMovie(id,movieDTO));
    }

    @DeleteMapping("/deletemovie/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
        return ResponseEntity.ok().build();
    }


}
