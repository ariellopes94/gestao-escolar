package com.ariellopes.gestaoescolar.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ariellopes.gestaoescolar.persistence.entity.CursoEntity;

public interface CursoRepository extends JpaRepository<CursoEntity, Long> {
	
}
