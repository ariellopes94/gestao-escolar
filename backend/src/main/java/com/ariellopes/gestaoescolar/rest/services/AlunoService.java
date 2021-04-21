package com.ariellopes.gestaoescolar.rest.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ariellopes.gestaoescolar.rest.controller.domain.dto.AlunoDto;
import com.ariellopes.gestaoescolar.rest.controller.domain.dto.CalculoNotaFinalAlunoDto;
import com.ariellopes.gestaoescolar.rest.controller.domain.dto.EditaAlunoDto;
import com.ariellopes.gestaoescolar.rest.controller.domain.dto.NovoAlunoDto;
import com.ariellopes.gestaoescolar.rest.model.Aluno;

public interface AlunoService {

	public Aluno criar (NovoAlunoDto novoAlunoDto);
	
	public Aluno editar(EditaAlunoDto editaAlunoDto, Long id);
	
	public void deletar(Long aluno);
	
	public Aluno buscarPorId(Long id);
	
	public AlunoDto buscarPorIdPersonalizado(Long id);
	
	public Page<Aluno> buscarTodos (Pageable pageable);
	
	public CalculoNotaFinalAlunoDto calcularNota(Long id);
	
}
