package com.workintech.s19d1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ActorRequest {

    private Actor actor;

    private List<Movie> movies;





}
