package edu.dio.springboot.exercises.demospringboot.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class GameCollection {

    private List<Game> gameList;

    public GameCollection() {
        this.gameList = new ArrayList();
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public void addGame(Game game) {
        this.gameList.add(game);
    }

    public void updateGame(Integer id, Game gameUpdated) {
        for (Game game : this.gameList) {
            if (game.getId() == id) {
                game.setName(gameUpdated.getName());
                game.setGender(gameUpdated.getGender());
            }
        }
    }

    public boolean deleteGame(Integer id) {
        return this.gameList.removeIf(x -> x.getId() == id);
    }

    @Override
    public String toString() {
        return this.gameList.stream().map(Game::toString).collect(Collectors.joining(", "));
    }

}
