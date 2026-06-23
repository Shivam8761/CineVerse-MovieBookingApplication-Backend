package com.sv.service;

import com.sv.DTO.TheaterDTO;
import com.sv.entity.Theater;
import com.sv.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    public Theater addTheater(TheaterDTO theaterDTO){

        Theater theater = new Theater();
        theater.setTheaterCapacity(theaterDTO.getTheaterCapacity());
        theater.setTheaterName(theaterDTO.getTheaterName());
        theater.setTheaterScreenType(theaterDTO.getTheaterScreenType());
        theater.setTheaterLocation(theaterDTO.getTheaterLocation());

        return theaterRepository.save(theater);
    }

    public List<Theater> getTheaterByLocation(String location){
        Optional<List<Theater>> opt = theaterRepository.findByTheaterLocation(location);
        if(opt.isPresent()){
            return  opt.get();
        }
        else{
            throw new RuntimeException("Theater not found on location "+location);
        }
    }

    public Theater updateTheater(Long id,TheaterDTO theaterDTO){

        Theater theater = theaterRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Theater is not found with id "+id));
        theater.setTheaterCapacity(theaterDTO.getTheaterCapacity());
        theater.setTheaterName(theaterDTO.getTheaterName());
        theater.setTheaterScreenType(theaterDTO.getTheaterScreenType());
        theater.setTheaterLocation(theaterDTO.getTheaterLocation());

        return theaterRepository.save(theater);

    }

    public void deleteTheater(Long id){
        theaterRepository.deleteById(id);
    }
}
