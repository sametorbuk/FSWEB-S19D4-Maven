package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.repository.ActorRepository;
import com.workintech.s19d1.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;
    private ActorRepository actorRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
        this.actorRepository=actorRepository;
    }


    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> findById(long id) {
        Optional<Movie> foundMovie=movieRepository.findById(id);
        if(foundMovie.isPresent()){
            return foundMovie;
        }

        else return null;
    }

    @Override
    public Map<Movie,Actor> save(Movie movie, Actor actor) {
       Movie willAddMovie=movie;
       Actor willAddActor=actor;
       willAddMovie.addActor(actor);
       willAddActor.addMovie(movie);
        actorRepository.save(willAddActor);
        movieRepository.save(willAddMovie);
        Map<Movie,Actor> map = new HashMap<>();
        map.put(willAddMovie,willAddActor);
       return map;
    }

    @Override
    public Movie delete(long id) {
        Optional<Movie> foundMovie=movieRepository.findById(id);
        if(foundMovie.isPresent()){
            movieRepository.deleteById(id);
        }
        return foundMovie.get();
    }

    @Override
    public Movie update(Movie movie , long id) {
        Optional<Movie> foundMovie=movieRepository.findById(id);
        if (foundMovie.isPresent()){
            movieRepository.deleteById(id);
            movieRepository.save(movie);
        }

        return null;
    }


    public Object save(Movie movie) {
      return   movieRepository.save(movie);
    }
}
