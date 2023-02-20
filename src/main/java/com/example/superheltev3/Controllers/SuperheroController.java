package com.example.superheltev3.Controllers;

import com.example.superheltev3.Model.Superhero;
import com.example.superheltev3.Services.SuperheroService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("superheroes")
public class SuperheroController {
    private SuperheroService superheroService;

    public SuperheroController(){
        superheroService = new SuperheroService();
    }

    @GetMapping("list")
    public ResponseEntity<List<Superhero>> listSuperheroes(){
        List superheroes = superheroService.getSuperheroes();

        return new ResponseEntity<>(superheroes, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<List<Superhero>> getSuperhero(@PathVariable String id){
        List foundSuperhero = superheroService.searchSuperHero(id);

        return new ResponseEntity<>(foundSuperhero, HttpStatus.OK);
    }

    @GetMapping("create")
    public ResponseEntity<List<Superhero>> createSuperhero(){
        superheroService.addSuperhero("Superman", "Klark Kent", "Everything", 420, 69.69);
        superheroService.addSuperhero("Spiderman", "Peter Parker", "Spider sense", 17, 420);
        superheroService.addSuperhero("The Flash", "Berry Allen", "Too fast", 19, 69.69);

        return new ResponseEntity<>(superheroService.getSuperheroes(), HttpStatus.OK);
    }

    @GetMapping("edit")
    public ResponseEntity<List<Superhero>> editSuperhero(){
        return new ResponseEntity<>(superheroService.getSuperheroes(), HttpStatus.OK);
    }

    @GetMapping("delete/{id}")
    public ResponseEntity<String> deleteSuperhero(@PathVariable String id){
        superheroService.removeSuperhero(id);

        return new ResponseEntity<>(id + " has been removed", HttpStatus.OK);
    }

    @RequestMapping("")
    public ResponseEntity<String> htmlSuperhero(@RequestParam String format){
        HttpHeaders header = new HttpHeaders();
        header.set("content-type", "text/html");
        StringBuilder sb = new StringBuilder();

        if (format != null && format.equals("html")){
            for (Superhero s : superheroService.getSuperheroes()){
                sb.append("<html><body><h1>");
                sb.append(s);
                sb.append("</h1></body></html>");
            }
            return new ResponseEntity<>(sb.toString(), header, HttpStatus.OK);
        }
        return new ResponseEntity<>("Something went wrong.", HttpStatus.BAD_REQUEST);
    }
}
