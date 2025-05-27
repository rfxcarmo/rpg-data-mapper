package com.rpg.datamapper.domain.model;


import lombok.Data;

@Data
public class Hero {
    private Long id;
    private String name;
    private int level = 1;
    private int experience = 0;
    private int health = 100;
    private int attack = 5;

    public Hero(Long id, String name) {
        this.name = name;
        this.id = id;
    }

    public Hero(String name) {
        this.name = name;
    }
}
