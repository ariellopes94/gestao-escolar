package com.ariellopes.gestaoescolar.rest.services.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ariellopes.gestaoescolar.exception.model.AlunoNaoEncontradoException;
import com.ariellopes.gestaoescolar.exception.model.CursoNaoEncontradoException;
import com.ariellopes.gestaoescolar.persistence.entity.CursoEntity;
import com.ariellopes.gestaoescolar.persistence.repository.CursoRepository;
import com.ariellopes.gestaoescolar.rest.controller.domain.dto.EditaCursoDto;
import com.ariellopes.gestaoescolar.rest.controller.domain.dto.NovoCursoDto;
import com.ariellopes.gestaoescolar.rest.model.Curso;
import com.ariellopes.gestaoescolar.rest.model.modelMapper.AlunoModelMapper;
import com.ariellopes.gestaoescolar.rest.services.CursoService;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	AlunoModelMapper modelMapper;

	@Override
	@Transactional
	public Curso criar(NovoCursoDto novoCursoDto) {

		CursoEntity cursoEntity = modelMapper.toEntityCursoEntity(novoCursoDto);
		cursoEntity = cursoRepository.save(cursoEntity);
		Curso curso = modelMapper.toEntityCurso(cursoEntity);

		return curso;

	}

	@Override
	@Transactional
	public Curso editar(EditaCursoDto editarCurso, Long id) {

		Curso aluno = buscarPorId(id);

		CursoEntity cursoEntity = modelMapper.toCurso(editarCurso);
		cursoEntity.setId(id);
		cursoEntity = cursoRepository.save(cursoEntity);
		Curso cursoModel = modelMapper.toCurso(cursoEntity);

		return cursoModel;
	}

	@Override
	public Curso buscarPorId(Long id) {

		verrificarExistencia(id);

		CursoEntity cursoEntity = cursoRepository.findById(id).get();
		Curso cursoModel = modelMapper.toCurso(cursoEntity);

		return cursoModel;
	}

	@Override
	public Page<Curso> buscarTodos(Pageable pageable) {

		Page<CursoEntity> cursoEntity = cursoRepository.findAll(pageable);

		if (cursoEntity.getTotalElements() == 0) {
			throw new AlunoNaoEncontradoException("Não existe Curso");
		}

		Page<Curso> curso = cursoEntity.map(modelMapper::toCurso);

		return curso;
	}

	private Boolean verrificarExistencia(Long codigo) {
		Optional<CursoEntity> obj = cursoRepository.findById(codigo);

		obj.orElseThrow(() -> new CursoNaoEncontradoException("Curso não encontrado"));
		return true;
	}

}
