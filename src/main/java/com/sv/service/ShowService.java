package com.sv.service;


import com.sv.DTO.ShowDTO;
import com.sv.entity.Booking;
import com.sv.entity.Movie;
import com.sv.entity.Show;
import com.sv.entity.Theater;
import com.sv.repository.MovieRepository;
import com.sv.repository.ShowRepository;
import com.sv.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    public Show createShow(ShowDTO showDTO){
        Movie movie = movieRepository.findById(showDTO.getMovieId())
                .orElseThrow(()->new RuntimeException("Movie not found"));

        Theater theater = theaterRepository.findById(showDTO.getTheaterId())
                .orElseThrow(()->new RuntimeException("Theater Not Found"));

        Show show = new Show();
        show.setShowTime(showDTO.getShowTime());
        show.setTheater(theater);
        show.setMovie(movie);
        show.setPrice(showDTO.getPrice());

        return showRepository.save(show);
    }

    public List<Show> getAllShows(){
        return showRepository.findAll();
    }

    public List<Show> getShowByMovie(Long movieId ){
        Optional<List<Show>> opt = showRepository.findByMovieId(movieId);
        if(opt.isPresent()){
            return opt.get();
        }
        else{
            throw new RuntimeException("No Shows available for the movie  ");
        }

    }

    public List<Show> getShowByTheater(Long theaterId){
        Optional<List<Show>> opt = showRepository.findByTheaterId(theaterId);
        if(opt.isPresent()){
            return opt.get();
        }
        else{
           throw new RuntimeException("No shows available for the Theater");
        }
    }

    public Show updateShow(Long id,ShowDTO showDTO ){

        Show show = showRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No Show is found"));

        Movie movie = movieRepository.findById(showDTO.getMovieId())
                .orElseThrow(()->new RuntimeException("Movie not found"));

        Theater theater = theaterRepository.findById(showDTO.getTheaterId())
                .orElseThrow(()->new RuntimeException("Theater Not Found"));

        show.setShowTime(showDTO.getShowTime());
        show.setTheater(theater);
        show.setMovie(movie);
        show.setPrice(showDTO.getPrice());

        return showRepository.save(show);

    }

    public void deleteShow(Long id){
       if(!showRepository.existsById(id)){
           throw  new RuntimeException("No Show available for the id "+id);
       }

       List<Booking> bookings = showRepository.findById(id).get().getBookings();
       if(!bookings.isEmpty()){
           throw new RuntimeException("Can't Delete show with existing bookings ");
       }

        showRepository.deleteById(id);
    }



}
