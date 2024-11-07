package com.workintech.s19d1.controller;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.ActorRequest;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.service.ActorServiceImpl;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/actor")
@NoArgsConstructor
public class ActorController {

    private ActorServiceImpl actorService;

    @Autowired
    public ActorController(ActorServiceImpl actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public List<Actor> findAll() {
        return actorService.findAll();
    }

    @GetMapping("/{id}")
    public Actor findById(@PathVariable long id) {
        return actorService.findById((int) id);
    }

    @PostMapping
    public Map<Movie, Actor> save(@RequestBody ActorRequest actorRequest) {
        Actor actor = actorRequest.getActor();
        Movie movie = actorRequest.getMovies().get(0);
        return actorService.save(movie, actor);
    }

    @PutMapping("/{id}")
    public Actor update(@RequestBody Actor actor, @PathVariable long id) {
        return actorService.update(actor, (int) id);
    }

    @DeleteMapping("/{id}")
    public Actor delete(@PathVariable long id) {
        return actorService.delete((int) id);
    }
}
