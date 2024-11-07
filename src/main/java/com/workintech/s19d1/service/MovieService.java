package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface MovieService {

    List<Movie> findAll();

    Optional<Movie> findById(long id);

    Map<Movie,Actor> save(Movie movie , Actor actor);

    Movie delete(long id);

    Movie update(Movie movie, long id);

}
