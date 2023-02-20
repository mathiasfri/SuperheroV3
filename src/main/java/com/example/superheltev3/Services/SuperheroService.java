package com.example.superheltev3.Services;

import com.example.superheltev3.Model.Superhero;
import com.example.superheltev3.Repositories.SuperheroRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SuperheroService {
    private SuperheroRepository superheroRepository;

    public SuperheroService(){
        superheroRepository = new SuperheroRepository();
    }

    public void addSuperhero(String heroName, String realName, String superpower, int age, double strength){
        superheroRepository.addSuperhero(heroName, realName, superpower, age, strength);
    }

    public ArrayList<Superhero> getSuperheroes(){
        return superheroRepository.getSuperheroes();
    }

    public ArrayList<Superhero> searchSuperHero(String name){
        return superheroRepository.searchSuperHeroes(name);
    }

    public void removeSuperhero(String name){
        superheroRepository.removeSuperhero(name);
    }
}
