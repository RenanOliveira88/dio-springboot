package edu.dio.springboot.exercises.demospringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.dio.springboot.exercises.demospringboot.Model.Game;
import edu.dio.springboot.exercises.demospringboot.Model.GameCollection;

@RestController
@RequestMapping("/games")
public class GameCollectionController {
    private final GameCollection gameCollection;

    @Autowired
    public GameCollectionController(){

        this.gameCollection = new GameCollection();
        Game game = new Game(1,"Resident Evil 4", "Survival horror");
        gameCollection.addGame(game);

        game = new Game(2,"Elden Ring", "Action RPG");
        gameCollection.addGame(game);

        game = new Game(3,"Sekiro", "Action");
        gameCollection.addGame(game);        
    }
    
    @GetMapping
    public String getGames(){
        return this.gameCollection.toString();
    }
    @PostMapping
    public Game addGame(@RequestBody Game newGame){
        this.gameCollection.addGame(newGame);
        return newGame;
    }
    @PutMapping("/{id}")
    public Game updateGame(@PathVariable Integer id, @RequestBody Game gameUpdated){
        this.gameCollection.updateGame(id, gameUpdated);
        return gameUpdated;
    }
    @DeleteMapping("/{id}")
    public boolean deleteGame(@PathVariable Integer id){
        return this.gameCollection.deleteGame(id);
    }
}
