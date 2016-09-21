package com.example.emmanuel.altomobile_test.animal_utils;


public class Animal {

    String name;
    int life;
    int id;


    @Override
    public String toString() {
        return name;
    }

    public int getLife(){
        return this.life;
    }
}
