package com.rpg.datamapper.application;

import com.rpg.datamapper.domain.model.Hero;
import com.rpg.datamapper.infrastructure.adapter.HeroRepositoryAdapter;
import com.rpg.datamapper.infrastructure.mapper.HeroMapper;
import com.rpg.datamapper.web.dto.HeroRequest;
import com.rpg.datamapper.web.dto.HeroResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class HeroService {
    private final HeroRepositoryAdapter repository;

    public HeroResponse getHeroById(Long id) {
        return HeroMapper.toResponse(repository.findById(id));
    }

    public List<HeroResponse> getHereos() {
        return repository.findAll()
                         .stream()
                         .map(HeroMapper::toResponse)
                         .collect(Collectors.toList());
    }

    public HeroResponse createHero(HeroRequest request) {
        Hero hero = new Hero(request.getName());
        repository.save(hero);

        return HeroMapper.toResponse(hero);
    }

    public void updateHero(Long id, HeroRequest request) {
        Hero hero = repository.findById(id);
        hero.setName(request.getName());
        repository.save(hero);
    }

    public void deleteHero(Long id) {
        repository.deleteById(id);
    }
}
