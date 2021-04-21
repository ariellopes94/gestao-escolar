package com.ariellopes.gestaoescolar.rest.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ariellopes.gestaoescolar.rest.controller.domain.dto.CursoDto;
import com.ariellopes.gestaoescolar.rest.controller.domain.dto.EditaCursoDto;
import com.ariellopes.gestaoescolar.rest.controller.domain.dto.NovoCursoDto;
import com.ariellopes.gestaoescolar.rest.model.Curso;

public interface CursoService {
	
	public Curso criar(NovoCursoDto novoCursoDto);
	
	public Curso editar(EditaCursoDto editarCurso, Long id);
	
	public Curso buscarPorId(Long id);
	
	public Page<Curso> buscarTodos (Pageable pageable);
	
	public CursoDto qtAlunoNoCursoAreaEspetifica(Long id);
}
