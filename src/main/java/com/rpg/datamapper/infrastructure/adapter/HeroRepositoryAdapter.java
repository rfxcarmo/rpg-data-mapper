package com.rpg.datamapper.infrastructure.adapter;

import com.rpg.datamapper.infrastructure.jpa.HeroJpaRepository;
import com.rpg.datamapper.domain.port.HeroRepository;
import com.rpg.datamapper.infrastructure.mapper.HeroMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import com.rpg.datamapper.domain.model.Hero;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class HeroRepositoryAdapter implements HeroRepository
{
    private final HeroJpaRepository jpa;

    @Override
    public void save(Hero hero) {
        jpa.save(HeroMapper.toEntity(hero));
    }

    @Override
    public void deleteById(Long id) { jpa.deleteById(id); }

    @Override
    public Hero findById(Long id) {
        return jpa.findById(id)
                .map(HeroMapper::toDomain)
                .orElseThrow(() -> new RuntimeException("Character not found"));
    }

    @Override
    public List<Hero> findAll() {
        return jpa.findAll()
                .stream()
                .map(HeroMapper::toDomain)
                .collect(Collectors.toList());
    }
}
