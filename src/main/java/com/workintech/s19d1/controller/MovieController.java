package com.workintech.s19d1.controller;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.service.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieServiceImpl movieService;

    @Autowired
    public MovieController(MovieServiceImpl movieService) {
        this.movieService = movieService;
    }


    @GetMapping
    public List<Movie> findAll(){
        return movieService.findAll();
    }


    @GetMapping("/{id}")
    public Optional<Movie> findById(long id){
        return movieService.findById(id);
    }

    @PostMapping("/")
    public Map<Movie,Actor> save(@RequestBody Movie movie, @RequestBody Actor actor){
       return movieService.save(movie,actor);
    }

    @PutMapping("/{id}")
    public Movie update(@RequestBody Movie movie,@PathVariable long id){
        return movieService.update(movie,id);
    }



}
