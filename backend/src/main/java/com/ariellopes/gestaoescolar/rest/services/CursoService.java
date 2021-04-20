package com.ariellopes.gestaoescolar.rest.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ariellopes.gestaoescolar.rest.model.Curso;

public interface CursoService {
	
	public Curso editar(Curso editaAlunoDto, Long id);
	
	public void deletar(Long aluno);
	
	public Curso buscarPorId(Long id);
	
	public Page<Curso> buscarTodos (Pageable pageable);
	
	
}
