package com.rpg.datamapper.web.controller;

import com.rpg.datamapper.application.HeroService;
import com.rpg.datamapper.web.dto.HeroRequest;
import com.rpg.datamapper.web.dto.HeroResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hero")
public class HeroController
{
    @Autowired
    private HeroService service;

    @GetMapping("/{id}")
    public HeroResponse getHeroById(@PathVariable Long id) {
        return service.getHeroById(id);
    }

    @GetMapping
    public List<HeroResponse> getAllHeroes() {
        return service.getHereos();
    }

    @PostMapping
    public HeroResponse create(@RequestBody HeroRequest hero) {
        return service.createHero(hero);
    }

    @PutMapping("/{id}")
    public void updateHero(@PathVariable Long id, @RequestBody HeroRequest hero) {
        service.updateHero(id, hero);
    }

    @DeleteMapping("/{id}")
    public void deleteHero(@PathVariable Long id) {
        service.deleteHero(id);
    }
}
