package com.workintech.s19d1.controller;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.ActorRequest;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.service.ActorServiceImpl;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Actor> save(@RequestBody ActorRequest actorRequest) {
        Actor savedActor = actorService.save(actorRequest);
        return ResponseEntity.status(HttpStatus.OK).body(savedActor);
    }

    @PutMapping("/{id}")
    public Actor update(@RequestBody ActorRequest actorRequest, @PathVariable long id) {
       return actorService.update(actorRequest,(int) id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Actor> delete(@PathVariable long id) {
        Actor deletedActor = actorService.delete((int) id);
        return ResponseEntity.ok(deletedActor);
    }


}
