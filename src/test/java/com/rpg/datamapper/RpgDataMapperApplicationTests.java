package com.rpg.datamapper;

import com.rpg.datamapper.application.HeroService;
import com.rpg.datamapper.infrastructure.adapter.HeroRepositoryAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
class RpgDataMapperApplicationTests {
    @BeforeEach
    public void setup() {
        HeroRepositoryAdapter repository = mock(HeroRepositoryAdapter.class);
        HeroService service = new HeroService(repository);
    }
}
