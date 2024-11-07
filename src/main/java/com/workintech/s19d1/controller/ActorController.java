package com.workintech.s19d1.controller;

import com.workintech.s19d1.entity.Actor;
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
@RequestMapping("/actors")
@NoArgsConstructor
public class ActorController {

    private ActorServiceImpl actorService;

    @Autowired
    public ActorController(ActorServiceImpl actorService) {
        this.actorService = actorService;
    }


    @GetMapping
    public List<Actor> findAll(){
        return actorService.findAll();
    }


    @GetMapping("/{id}")
    public Actor findById(@PathVariable int id){
     return   actorService.findById(id);
    }

    @PostMapping
    public Actor save(@RequestBody Movie movie,@RequestBody Actor actor){
        return actorService.save(actor);
    }

    @PutMapping("/{id}")
    public Actor update(@RequestBody Actor actor , @PathVariable int id){
        return actorService.update(actor,id);
    }



}
