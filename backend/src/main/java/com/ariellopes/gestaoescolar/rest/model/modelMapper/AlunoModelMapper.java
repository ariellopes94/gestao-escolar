package com.ariellopes.gestaoescolar.rest.model.modelMapper;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.ariellopes.gestaoescolar.persistence.entity.AlunoEntity;
import com.ariellopes.gestaoescolar.rest.controller.domain.dto.CalculoNotaFinalAlunoDto;
import com.ariellopes.gestaoescolar.rest.controller.domain.dto.EditaAlunoDto;
import com.ariellopes.gestaoescolar.rest.controller.domain.dto.NovoAlunoDto;
import com.ariellopes.gestaoescolar.rest.model.Aluno;
import com.fasterxml.jackson.annotation.JsonFormat;

@Component
public class AlunoModelMapper {

	public AlunoEntity toEntity(NovoAlunoDto novoAlunoDto) {

		AlunoEntity alunoEntity = new AlunoEntity();

		alunoEntity.setDataCadastro(new Date());
		alunoEntity.setNome(novoAlunoDto.getNome());
		alunoEntity.setEmail(novoAlunoDto.getEmail());
		alunoEntity.setTelefone(novoAlunoDto.getTelefone());
		alunoEntity.setIdade(novoAlunoDto.getIdade());
		
		return alunoEntity;
	}
	
	public AlunoEntity toEntity(Aluno aluno) {

		AlunoEntity alunoEntity = new AlunoEntity();

		alunoEntity.setId(aluno.getId());
		alunoEntity.setDataCadastro(aluno.getDataCadastro());
		alunoEntity.setNome(aluno.getNome());
		alunoEntity.setEmail(aluno.getEmail());
		alunoEntity.setTelefone(aluno.getTelefone());
		alunoEntity.setIdade(aluno.getIdade());
		alunoEntity.setMatricula(aluno.getMatricula());
		
		return alunoEntity;
	}
	
	public AlunoEntity toEntity(EditaAlunoDto editaAlunoDto) {

		AlunoEntity alunoEntity = new AlunoEntity();

		alunoEntity.setNome(editaAlunoDto.getNome());
		alunoEntity.setEmail(editaAlunoDto.getEmail());
		alunoEntity.setTelefone(editaAlunoDto.getTelefone());
		alunoEntity.setIdade(editaAlunoDto.getIdade());
		
		return alunoEntity;
	}

	public Aluno toAluno(AlunoEntity alunoEntity) {

		Aluno aluno = new Aluno();
		

		aluno.setMatricula(alunoEntity.getMatricula());
		aluno.setId(alunoEntity.getId());
		aluno.setDataCadastro(alunoEntity.getDataCadastro());
		aluno.setNome(alunoEntity.getNome());
		aluno.setIdade(alunoEntity.getIdade());
		aluno.setEmail(alunoEntity.getEmail());
		aluno.setTelefone(alunoEntity.getTelefone());
		
		
		return aluno;
	}
	
	public CalculoNotaFinalAlunoDto toCalculoNotaFinal(AlunoEntity alunoEntity) {

		CalculoNotaFinalAlunoDto calculoNotaFinalAlunoDto = new CalculoNotaFinalAlunoDto();
		

		calculoNotaFinalAlunoDto.setId(alunoEntity.getId());
		calculoNotaFinalAlunoDto.setDataCadastro(alunoEntity.getDataCadastro());
		calculoNotaFinalAlunoDto.setNome(alunoEntity.getNome());
		calculoNotaFinalAlunoDto.setIdade(alunoEntity.getIdade());
		calculoNotaFinalAlunoDto.setEmail(alunoEntity.getEmail());
		calculoNotaFinalAlunoDto.setTelefone(alunoEntity.getTelefone());
		
		return calculoNotaFinalAlunoDto;
	}
}
