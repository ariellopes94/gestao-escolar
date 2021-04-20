package com.ariellopes.gestaoescolar.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ariellopes.gestaoescolar.persistence.entity.AlunoEntity;
import com.ariellopes.gestaoescolar.persistence.entity.DisciplinaEntity;
import com.ariellopes.gestaoescolar.persistence.entity.DisciplinaNotaEntity;

public interface DisciplinaNotaRepository extends JpaRepository<DisciplinaNotaEntity, Long> {

}
