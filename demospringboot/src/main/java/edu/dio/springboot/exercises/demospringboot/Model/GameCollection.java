package edu.dio.springboot.exercises.demospringboot.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class GameCollection {
    List<Game> gameList;

    public GameCollection(){
        this.gameList = new ArrayList();
    }

    public void addGame(Game game){
        this.gameList.add(game);
    }
    @Override
    public String toString(){
        return this.gameList.stream().map(Game::toString).collect(Collectors.joining(", "));
    }
}
