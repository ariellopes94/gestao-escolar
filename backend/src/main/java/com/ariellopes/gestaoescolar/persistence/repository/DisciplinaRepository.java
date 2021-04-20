package com.ariellopes.gestaoescolar.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ariellopes.gestaoescolar.persistence.entity.DisciplinaEntity;

public interface DisciplinaRepository extends JpaRepository<DisciplinaEntity, Long> {

}
