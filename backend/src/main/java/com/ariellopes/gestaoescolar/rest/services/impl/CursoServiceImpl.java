package com.ariellopes.gestaoescolar.rest.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ariellopes.gestaoescolar.persistence.repository.AlunoRepository;
import com.ariellopes.gestaoescolar.persistence.repository.DisciplinaRepository;
import com.ariellopes.gestaoescolar.rest.model.Curso;
import com.ariellopes.gestaoescolar.rest.services.CursoService;

@Service
public class CursoServiceImpl implements CursoService {

	
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@Autowired
	AlunoRepository alunoService;
	
	

	@Override
	public Curso editar(Curso editaAlunoDto, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(Long aluno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Curso buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Curso> buscarTodos(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}



}
