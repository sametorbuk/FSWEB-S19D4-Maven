package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.ActorRequest;
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

    private  ActorRepository actorRepository;


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
        throw new ApiException("actor is not found with id: "+ id, HttpStatus.NOT_FOUND);
    }

    @Override
    public Actor save(ActorRequest actorRequest) {
        Actor actor = actorRequest.getActor();
        List<Movie> movie = actorRequest.getMovies();
        actor.setMovies(movie);
     return   actorRepository.save(actor);
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
    public Actor update(ActorRequest actorRequest, int id) {
      Actor actor = actorRequest.getActor();
      List<Movie> movies = actorRequest.getMovies();
      Optional<Actor> foundActor=actorRepository.findById((long) id);
      if(foundActor.isPresent()){
          Actor actor1 = foundActor.get();
          actor1.setBirthDate(actor.getBirthDate());
          actor1.setGender(actor.getGender());
          actor1.setMovies(movies);
          actor1.setLastName(actor.getLastName());
          actor1.setFirstName(actor.getFirstName());
          actorRepository.save(actor1);
          return actor;
      }

      throw new ApiException("There is no actor with this id",HttpStatus.NOT_FOUND);
    }

    public Actor save(Actor actor) {
     return   actorRepository.save(actor);
    }
}
