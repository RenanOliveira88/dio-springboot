package edu.dio.springboot.exercises.demospringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import edu.dio.springboot.exercises.demospringboot.exception.ResourceNotFoundException;

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
    public ResponseEntity<String> getGames(){
        if (this.gameCollection == null){
            throw new RuntimeException("Erro fatal, a coleção de jogos não foi criada. \n Reinicie a aplicação.");
        }
        return ResponseEntity.ok(this.gameCollection.toString());
    }
    @PostMapping
    public ResponseEntity<Game> addGame(@RequestBody Game newGame){
        if (!this.gameCollection.addGame(newGame)){
            throw new RuntimeException("Não foi possível cadastrar o jogo com esse ID.");
        }
        return ResponseEntity.ok(newGame);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Game> updateGame(@PathVariable Integer id, @RequestBody Game gameUpdated){
        if(!this.gameCollection.updateGame(id, gameUpdated)){
            throw new ResourceNotFoundException("Jogo não encontrado.");
        }
        return ResponseEntity.ok(gameUpdated);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Integer id){
        if (!this.gameCollection.deleteGame(id)){
            throw new ResourceNotFoundException("Jogo não encontrado.");
        }
        return ResponseEntity.noContent().build();
    }
}
