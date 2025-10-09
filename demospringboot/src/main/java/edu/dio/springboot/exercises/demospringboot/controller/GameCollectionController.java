package edu.dio.springboot.exercises.demospringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}
