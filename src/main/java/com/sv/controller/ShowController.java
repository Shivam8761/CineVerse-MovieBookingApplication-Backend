package com.sv.controller;

import com.sv.DTO.ShowDTO;
import com.sv.entity.Show;
import com.sv.service.ShowService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/show")
@Tag(name = "Show Management", description = "APIs for managing movie shows, schedules and show information")
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping("/createshow")
    public ResponseEntity<Show> createShow(@RequestBody ShowDTO showDTO){
        return ResponseEntity.ok(showService.createShow(showDTO));
    }

    @GetMapping("/getallshows")
    public ResponseEntity<List<Show>> getAllShows(){
          return ResponseEntity.ok(showService.getAllShows());
    }

    @GetMapping("/getshowbymovie/{id}")
    public ResponseEntity<List<Show>> showByMovie(@PathVariable Long id ){
        return ResponseEntity.ok(showService.getShowByMovie(id));
    }

    @GetMapping("/getshowbytheater/{id}")
    public ResponseEntity<List<Show>> getShowByTheater(@PathVariable Long id) {
        return ResponseEntity.ok(showService.getShowByTheater(id));
    }

    @PutMapping("/updateshow/{id}")
    public ResponseEntity<Show> updateShow(@PathVariable Long id,@RequestBody ShowDTO showDTO){
        return  ResponseEntity.ok(showService.updateShow(id,showDTO));
    }

    @DeleteMapping("deleteshow/{id}")
    public ResponseEntity<Void> deleteShow(@PathVariable Long id ){
        showService.deleteShow(id);
        return  ResponseEntity.ok().build();
    }

}
