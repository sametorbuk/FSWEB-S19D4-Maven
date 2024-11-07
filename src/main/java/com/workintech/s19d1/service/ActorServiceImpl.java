package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.ActorRequest;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.exceptions.ApiException;
import com.workintech.s19d1.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;

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
        throw new ApiException("actor is not found with id: " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public Actor save(ActorRequest actorRequest) {
        Actor actor = actorRequest.getActor();
        actor.setMovies(actorRequest.getMovies());
        return actorRepository.save(actor);
    }

    @Override
    public Actor save(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Actor delete(long id) {
        Optional<Actor> actor = actorRepository.findById(id);
        if (actor.isPresent()) {
            actorRepository.deleteById(id);
            return actor.get();
        }
        throw new ApiException("Actor not found with id: " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public Actor update(ActorRequest actorRequest, int id) {
        Actor actor = actorRequest.getActor();
        List<Movie> movies = actorRequest.getMovies();
        Optional<Actor> foundActor = actorRepository.findById((long) id);
        if (foundActor.isPresent()) {
            Actor existingActor = foundActor.get();
            existingActor.setFirstName(actor.getFirstName());
            existingActor.setLastName(actor.getLastName());
            existingActor.setBirthDate(actor.getBirthDate());
            existingActor.setGender(actor.getGender());
            existingActor.setMovies(movies);
            return actorRepository.save(existingActor);
        }
        throw new ApiException("Actor not found with id: " + id, HttpStatus.NOT_FOUND);
    }
}
