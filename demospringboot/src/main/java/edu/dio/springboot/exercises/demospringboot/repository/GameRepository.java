package edu.dio.springboot.exercises.demospringboot.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.dio.springboot.exercises.demospringboot.Model.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
