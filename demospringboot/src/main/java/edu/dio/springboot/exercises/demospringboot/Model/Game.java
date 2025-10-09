package edu.dio.springboot.exercises.demospringboot.Model;

public class Game {
    int id;
    String name;
    String gender;

    public Game(String name, String gender){
        this.name = name;
        this.gender = gender;
    }

    public Game(int id, String name, String gender){
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString(){
        return "Id=" + this.id +
               "Name=" + this.name + 
               "Gender=" + this.gender;
    }
}
