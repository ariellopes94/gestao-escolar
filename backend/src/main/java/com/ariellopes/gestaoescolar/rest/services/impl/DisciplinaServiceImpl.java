package com.ariellopes.gestaoescolar.rest.services.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ariellopes.gestaoescolar.exception.model.CursoNaoEncontradoException;
import com.ariellopes.gestaoescolar.persistence.entity.CursoEntity;
import com.ariellopes.gestaoescolar.persistence.entity.DisciplinaEntity;
import com.ariellopes.gestaoescolar.persistence.repository.DisciplinaRepository;
import com.ariellopes.gestaoescolar.rest.controller.domain.dto.NovaDisciplinaDto;
import com.ariellopes.gestaoescolar.rest.model.Curso;
import com.ariellopes.gestaoescolar.rest.model.Disciplina;
import com.ariellopes.gestaoescolar.rest.model.modelMapper.AlunoModelMapper;
import com.ariellopes.gestaoescolar.rest.services.CursoService;
import com.ariellopes.gestaoescolar.rest.services.DisciplinaService;

@Service
public class DisciplinaServiceImpl implements DisciplinaService {

	@Autowired
	private DisciplinaRepository disciplinaRepository;

	@Autowired
	private AlunoModelMapper modelMapper;

	@Autowired
	private CursoService cursoService;
	
	@Override
	@Transactional
	public Disciplina criar(NovaDisciplinaDto novaDisciplinaDto) {
		
		Curso curso =cursoService.buscarPorId(novaDisciplinaDto.getCursoEntity().getId());
		CursoEntity cursoEntity = new CursoEntity(curso.getId(), curso.getNome(), curso.getDescricaoCurso());
	
		DisciplinaEntity disciplinaEntity = modelMapper.toDisciplinaModel(novaDisciplinaDto);
		
		disciplinaEntity.setCursoEntity(cursoEntity);
		
		disciplinaEntity = disciplinaRepository.save(disciplinaEntity);
		Disciplina disciplina = modelMapper.toDisciplina(disciplinaEntity);

		return disciplina;

	}
	
	
	public DisciplinaEntity buscarPorId(Long id) {
		
		verrificarExistencia(id);
		DisciplinaEntity disciplinaEntity = disciplinaRepository.findById(id).get();

		return disciplinaEntity;
	}
	
	private Boolean verrificarExistencia(Long codigo) {
		Optional<DisciplinaEntity> obj = disciplinaRepository.findById(codigo);

		obj.orElseThrow(() -> new CursoNaoEncontradoException("Disciplina não encontrado"));
		return true;
	}

}
