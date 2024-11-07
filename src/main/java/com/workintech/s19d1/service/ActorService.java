package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ActorService {
    List<Actor> findAll();

    Actor findById(int id);

    Map<Movie, Actor> save(Movie movie, Actor actor);

    Actor save(Actor actor);

    Actor delete(int id);

    Actor update(Actor actor, int id);
}
