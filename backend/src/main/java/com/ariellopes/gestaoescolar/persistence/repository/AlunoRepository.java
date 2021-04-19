package com.ariellopes.gestaoescolar.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ariellopes.gestaoescolar.persistence.domain.entity.AlunoEntity;

public interface AlunoRepository extends JpaRepository<AlunoEntity, Long> {

}
