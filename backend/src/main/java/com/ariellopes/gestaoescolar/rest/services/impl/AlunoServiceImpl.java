package com.ariellopes.gestaoescolar.rest.services.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ariellopes.gestaoescolar.exception.model.AlunoNaoEncontradoException;
import com.ariellopes.gestaoescolar.persistence.entity.AlunoEntity;
import com.ariellopes.gestaoescolar.persistence.entity.DisciplinaNotaEntity;
import com.ariellopes.gestaoescolar.persistence.repository.AlunoRepository;
import com.ariellopes.gestaoescolar.rest.controller.domain.dto.EditaAlunoDto;
import com.ariellopes.gestaoescolar.rest.controller.domain.dto.NovoAlunoDto;
import com.ariellopes.gestaoescolar.rest.model.Aluno;
import com.ariellopes.gestaoescolar.rest.model.DisciplinaNota;
import com.ariellopes.gestaoescolar.rest.model.modelMapper.AlunoModelMapper;
import com.ariellopes.gestaoescolar.rest.services.AlunoService;

@Service
public class AlunoServiceImpl implements AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	AlunoModelMapper modelMapper;

	@Override
	@Transactional
	public Aluno criar(NovoAlunoDto novoAlunoDto) {

		AlunoEntity alunoEntity = modelMapper.toEntity(novoAlunoDto);
		alunoEntity = alunoRepository.save(alunoEntity);
		Aluno aluno = modelMapper.toAluno(alunoEntity);

		return aluno;

	}

	@Override
	@Transactional
	public Aluno editar(EditaAlunoDto editaAlunoDto, Long id) {

		Aluno aluno = buscarPorId(id);

		AlunoEntity alunoEntity = modelMapper.toEntity(editaAlunoDto);
		alunoEntity.setId(id);
		alunoEntity.setDataCadastro(aluno.getDataCadastro());
		alunoEntity = alunoRepository.save(alunoEntity);
		Aluno alunoModel = modelMapper.toAluno(alunoEntity);

		return alunoModel;
	}

	@Override
	@Transactional
	public void deletar(Long id) {

		verrificarExistencia(id);

		alunoRepository.deleteById(id);
	}

	@Override
	public Aluno buscarPorId(Long id) {

		verrificarExistencia(id);

		AlunoEntity alunoEntity = alunoRepository.findById(id).get();
		Aluno aluno = modelMapper.toAluno(alunoEntity);

		return aluno;
	}

	@Override
	public Page<Aluno> buscarTodos(Pageable pageable) {

		Page<AlunoEntity> alunoEntity = alunoRepository.findAll(pageable);

		if (alunoEntity.getTotalElements() == 0) {
			throw new AlunoNaoEncontradoException("Não existe Aluno");
		}

		Page<Aluno> aluno = alunoEntity.map(modelMapper::toAluno);

		return aluno;
	}

	private Boolean verrificarExistencia(Long codigo) {
		Optional<AlunoEntity> obj = alunoRepository.findById(codigo);

		obj.orElseThrow(() -> new AlunoNaoEncontradoException("Aluno não encontrado"));
		return true;
	}

	@Override
	public Double calcularNota(Long id) {
		
		Aluno aluno = buscarPorId(id);
		
		AlunoEntity alunoEntity = modelMapper.toEntity(aluno);
		
		Double numero = 0d;
		
		
		System.out.println("=========================================");
		
		for(DisciplinaNotaEntity alunoNota: alunoEntity.getMatricula()) {
			
			System.out.println(aluno.getEmail());
			numero +=  alunoNota.getNota();
			System.out.print(alunoNota.getNota());
			
		}
		
		return numero /3;
	}

}
