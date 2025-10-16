package edu.dio.springboot.exercises.demospringboot.Model;

public class Game {
    int id;
    String name;
    String gender;

    public Game(){
    }
    public Game(String name, String gender){
        this.name = name;
        this.gender = gender;
    }
    
    public Game(int id, String name, String gender){
        this.id = id;
        this.name = name;
        this.gender = gender;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
