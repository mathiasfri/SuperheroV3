package com.example.superheltev3.Repositories;

import com.example.superheltev3.Model.Superhero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class SuperheroRepository {
    private ArrayList<Superhero> superheroes = new ArrayList<>();

    public void addSuperhero(String heroName, String realName, String superpower, int age, double strength)
    {
        superheroes.add(new Superhero(heroName, realName, superpower, age, strength));
    }

    public SuperheroRepository(){
        addSuperhero("Superman", "Klark Kent", "Everything", 420, 69.69);
        addSuperhero("Spiderman", "Peter Parker", "Spider sense", 17, 420);
        addSuperhero("The Flash", "Berry Allen", "Too fast", 19, 69.69);
    }

    public ArrayList<Superhero> getSuperheroes()
    {
        return superheroes;
    }

    public ArrayList<Superhero> searchSuperHeroes(String name)
    {
        ArrayList<Superhero> searchedSuperheroes = new ArrayList<>();

        for (Superhero superhero : superheroes) {
            if (superhero.getHeroName().toLowerCase().contains(name.toLowerCase())) {
                searchedSuperheroes.add(superhero);
            }
        }
        return searchedSuperheroes;
    }

    public void removeSuperhero(String name)
    {
        for (Superhero s : superheroes) {
            if (s.getHeroName().toLowerCase().contains(name.toLowerCase())) {
                superheroes.remove(s);
            }
        }
    }
}
