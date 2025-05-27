package com.rpg.datamapper.infrastructure.jpa;

import com.rpg.datamapper.infrastructure.entity.HeroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroJpaRepository extends JpaRepository<HeroEntity, Long> {}
