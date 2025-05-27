package com.rpg.datamapper.web.dto;

import com.rpg.datamapper.infrastructure.mapper.contracts.HeroLike;
import lombok.Data;

@Data
public class HeroResponse implements HeroLike {
    private Long id;
    private String name;
    private int level;
    private int experience;
    private int health;
    private int attack;
}
