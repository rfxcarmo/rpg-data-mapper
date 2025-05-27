package com.rpg.datamapper.domain.port;

import com.rpg.datamapper.domain.model.Hero;

import java.util.List;

public interface HeroRepository {
    Hero findById(Long id);
    void save(Hero hero);
    List<Hero> findAll();
    void deleteById(Long id);
}
