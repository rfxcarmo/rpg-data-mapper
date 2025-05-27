package com.rpg.datamapper.infrastructure.entity;

import com.rpg.datamapper.infrastructure.mapper.contracts.HeroLike;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity(name = "hero")
@Data
public class HeroEntity implements HeroLike{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int level;
    private int attack;
    private int experience;
    private int health;
}
