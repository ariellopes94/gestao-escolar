package com.ariellopes.gestaoescolar.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ariellopes.gestaoescolar.persistence.entity.AlunoEntity;

public interface AlunoRepository extends JpaRepository<AlunoEntity, Long> {
	
	@Query(value = "SELECT * FROM TB_ALUNO WHERE CURSO_ID = ?1", nativeQuery = true)
	List<AlunoEntity> findQuantidadeAlunoMatriculadoEmCadaCurso(int idAluno);
}
