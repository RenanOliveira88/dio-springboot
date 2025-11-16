package edu.dio.springboot.exercises.demospringboot.controller;

import java.util.List;

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
import edu.dio.springboot.exercises.demospringboot.repository.GameRepository;

@RestController
@RequestMapping("/games")
public class GameCollectionController {
    private final GameRepository repository;
    @Autowired
    public GameCollectionController(GameRepository repository){
        this.repository = repository;
        
        Game game = new Game("Resident Evil 4", "Survival horror");
        repository.save(game);

        game = new Game("Elden Ring", "Action RPG");
        repository.save(game);

        game = new Game("Sekiro", "Action");
        repository.save(game);        
    }
    
    @GetMapping
    public ResponseEntity<String> getGames(){
        List<Game> gameCollection = repository.findAll();
        if (gameCollection == null){
            throw new RuntimeException("Erro fatal, a coleção de jogos não foi criada. \n Reinicie a aplicação.");
        }
        return ResponseEntity.ok(gameCollection.toString());
    }
    @PostMapping
    public ResponseEntity<Game> addGame(@RequestBody Game newGame){
        repository.save(newGame);
        return ResponseEntity.ok(newGame);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Game> updateGame(@PathVariable Long id, @RequestBody Game gameUpdated){
        return repository.findById(id)
        .map(gameExistente -> {
            gameExistente.setName(gameUpdated.getName());
            gameExistente.setGender(gameUpdated.getGender());
            Game atualizada = repository.save(gameExistente);
            return ResponseEntity.ok(atualizada);
        })
        .orElse(ResponseEntity.notFound().build());


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id){
        repository.delete(repository.findById(id).orElse(null));
        return ResponseEntity.noContent().build();
    }
}
