package com.rpg.datamapper.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rpg.datamapper.application.HeroService;
import com.rpg.datamapper.domain.port.HeroRepository;
import com.rpg.datamapper.web.dto.HeroRequest;
import com.rpg.datamapper.web.dto.HeroResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.rpg.datamapper.domain.model.Hero;

import java.util.List;

import static org.junit.jupiter.api.extension.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HeroController.class)
public class HeroControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HeroRepository repository;

    @MockBean
    private HeroService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateHero() throws Exception {
        HeroRequest request = new HeroRequest();
        request.setName("Geralt");

        Mockito.doNothing().when(repository).save(Mockito.any());

        mockMvc.perform(post("/hero")
                        .contentType(String.valueOf(APPLICATION_JSON))
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnHeroById() throws Exception {
        long id = 1L;
        Hero hero = new Hero(id, "Yennefer");

        Mockito.when(repository.findById(id)).thenReturn(hero);

        mockMvc.perform(get("/hero/" + id))
                .andExpect(status().isOk());
    }

    @Test
    void shouldUpdateHero() throws Exception {
        long id = 1L;
        HeroRequest request = new HeroRequest();
        request.setName("Triss");

        Mockito.doNothing().when(service).updateHero(Mockito.eq(id), Mockito.any(HeroRequest.class));

        mockMvc.perform(put("/hero/{id}", id)
                        .contentType(String.valueOf(APPLICATION_JSON))
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }

    @Test
    void shouldDeleteHero() throws Exception {
        long id = 1L;

        Mockito.doNothing().when(service).deleteHero(id);

        mockMvc.perform(delete("/hero/{id}", id))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnAllHeroes() throws Exception {
        HeroResponse hero1 = new HeroResponse();
        hero1.setId(1L);
        hero1.setName("Geralt");
        HeroResponse hero2 = new HeroResponse();
        hero2.setId(2L);
        hero2.setName("Yennefer");

        Mockito.when(service.getHereos()).thenReturn(List.of(hero1, hero2));

        mockMvc.perform(get("/hero"))
                .andExpect(status().isOk());
    }
}
