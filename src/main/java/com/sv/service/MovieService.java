package com.sv.service;


import com.sv.DTO.MovieDTO;
import com.sv.entity.Movie;
import com.sv.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie addMovie(MovieDTO movieDTO){

        Movie movie = new Movie();
        movie.setName(movieDTO.getName());
        movie.setDescription(movieDTO.getDescription());
        movie.setGenre(movieDTO.getGenre());
        movie.setLanguage(movieDTO.getLanguage());
        movie.setReleaseDate(movieDTO.getReleaseDate());
        movie.setDuration(movieDTO.getDuration());

        return movieRepository.save(movie);

    }

    public List<Movie> getAllMovie(){
        return movieRepository.findAll();
    }

    public List<Movie> getMovieByGenre(String genre){
        Optional<List<Movie>> opt   =movieRepository.findByGenre(genre);
        if(opt.isPresent()){
            return opt.get();
        }
        else{
            throw new RuntimeException("Movie not found for genre "+genre);
        }

    }

    public List<Movie> getMovieByLanguage(String language){
        Optional<List<Movie>> opt = movieRepository.findByLanguage(language);
        if(opt.isPresent()){
            return opt.get();
        }
        else{
            throw new RuntimeException("Movie not found for language "+language);
        }
    }

    public Movie getMovieByTitle(String title){
        Optional<Movie> opt = movieRepository.findByName(title);
        if(opt.isPresent()){
            return  opt.get();
        }
        else {
            throw new RuntimeException("Movie not found for Title "+title);
        }
    }

    public Movie updateMovie(Long id,MovieDTO movieDTO){
        Movie movie = movieRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Movie not found "+id));
        movie.setName(movieDTO.getName());
        movie.setDescription(movieDTO.getDescription());
        movie.setGenre(movieDTO.getGenre());
        movie.setLanguage(movieDTO.getLanguage());
        movie.setReleaseDate(movieDTO.getReleaseDate());
        movie.setDuration(movieDTO.getDuration());

        return movieRepository.save(movie);
    }

    public void deleteMovie(Long id){
        movieRepository.deleteById(id);
    }


}
