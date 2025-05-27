package com.rpg.datamapper.infrastructure.mapper;

import com.rpg.datamapper.infrastructure.entity.HeroEntity;
import com.rpg.datamapper.domain.model.Hero;
import com.rpg.datamapper.infrastructure.mapper.contracts.HeroLike;
import com.rpg.datamapper.web.dto.HeroResponse;

import java.util.function.Supplier;

public class HeroMapper {
    public static Hero toDomain(HeroEntity e) {
        Hero c = new Hero(e.getId(), e.getName());
        c.setLevel(e.getLevel());
        c.setExperience(e.getExperience());
        c.setHealth(e.getHealth());
        c.setAttack(e.getAttack());

        return c;
    }

    public static HeroEntity toEntity(Hero hero) {
        return toGeneric(hero, HeroEntity::new);
    }

    public static HeroResponse toResponse(Hero hero) {
        return toGeneric(hero, HeroResponse::new);
    }

    public static <T extends HeroLike> T toGeneric(Hero hero, Supplier<T> constructor) {
        T result = constructor.get();
        result.setId(hero.getId());
        result.setName(hero.getName());
        result.setLevel(hero.getLevel());
        result.setExperience(hero.getExperience());
        result.setHealth(hero.getHealth());
        result.setAttack(hero.getAttack());
        return result;
    }
}
