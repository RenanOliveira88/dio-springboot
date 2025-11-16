package edu.dio.springboot.exercises.demospringboot.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String gender;

    public Game(){
    }
    public Game(String name, String gender){
        this.name = name;
        this.gender = gender;
    }
    
    public Game(Long id, String name, String gender){
        this.id = id;
        this.name = name;
        this.gender = gender;
    }
    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString(){
        return "Id=" + this.id +
               "Name=" + this.name + 
               "Gender=" + this.gender;
    }

}
