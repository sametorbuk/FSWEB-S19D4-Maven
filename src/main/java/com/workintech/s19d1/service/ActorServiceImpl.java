package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.exceptions.ApiException;
import com.workintech.s19d1.repository.ActorRepository;
import com.workintech.s19d1.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService {

    private ActorRepository actorRepository;
    private MovieRepository movieRepository;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository, MovieRepository movieRepository) {
        this.actorRepository = actorRepository;
        this.movieRepository = movieRepository;
    }

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Override
    public Actor findById(int id) {
        Optional<Actor> foundActor = actorRepository.findById((long) id);
        if (foundActor.isPresent()) {
            return foundActor.get();
        }
        throw new ApiException("There is no actor with this id", HttpStatus.NOT_FOUND);
    }

    @Override
    public Map<Movie, Actor> save(Movie movie, Actor actor) {
        actor.addMovie(movie);
        movie.addActor(actor);

        actorRepository.save(actor);
        movieRepository.save(movie);

        Map<Movie, Actor> map = new HashMap<>();
        map.put(movie, actor);
        return map;
    }

    @Override
    public Actor delete(int id) {
        Optional<Actor> foundActor = actorRepository.findById((long) id);
        if (foundActor.isPresent()) {
            actorRepository.deleteById((long) id);
            return foundActor.get();
        }
        throw new ApiException("There is no actor with this id", HttpStatus.NOT_FOUND);
    }

    @Override
    public Actor update(Actor actor, int id) {
        Optional<Actor> foundActor = actorRepository.findById((long) id);
        if (foundActor.isPresent()) {
            actorRepository.deleteById((long) id);
            actor.setId(id);
            actorRepository.save(actor);
            return actor;
        }
        throw new ApiException("There is no actor with this id", HttpStatus.NOT_FOUND);
    }

    public Actor save(Actor actor) {
     return   actorRepository.save(actor);
    }
}
