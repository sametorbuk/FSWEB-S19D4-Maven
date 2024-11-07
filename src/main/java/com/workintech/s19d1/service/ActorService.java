package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;

import java.util.List;
import java.util.Map;

public interface ActorService {
    List<Actor> findAll();

    Actor findById(int id);

    Map<Movie, Actor> save(Movie movie, Actor actor);

    Actor save(Actor actor);

    Actor delete(int id);

    Actor update(Actor actor, int id);
}
