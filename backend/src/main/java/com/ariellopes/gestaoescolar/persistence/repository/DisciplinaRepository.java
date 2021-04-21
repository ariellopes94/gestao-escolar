package com.ariellopes.gestaoescolar.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ariellopes.gestaoescolar.persistence.entity.DisciplinaEntity;
import com.ariellopes.gestaoescolar.rest.model.Disciplina;

public interface DisciplinaRepository extends JpaRepository<DisciplinaEntity, Long> {

	//List<Disciplina> findByCursoId(Integer id);
	
}
