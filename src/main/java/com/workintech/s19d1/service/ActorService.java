package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.ActorRequest;
import com.workintech.s19d1.entity.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ActorService {
    List<Actor> findAll();

    Actor findById(int id);

    Actor save(ActorRequest actorRequest);

    Actor save(Actor actor);

    Actor delete(long id);

    Actor update(ActorRequest actor, int id);
}
