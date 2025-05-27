package com.rpg.datamapper.infrastructure.mapper.contracts;

public interface HeroLike {
    void setId(Long id);
    void setName(String name);
    void setLevel(int level);
    void setExperience(int experience);
    void setHealth(int health);
    void setAttack(int attack);
}
