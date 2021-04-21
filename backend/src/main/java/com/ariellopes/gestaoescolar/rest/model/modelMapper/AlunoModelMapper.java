package com.ariellopes.gestaoescolar.rest.model.modelMapper;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.ariellopes.gestaoescolar.persistence.entity.AlunoEntity;
import com.ariellopes.gestaoescolar.persistence.entity.CursoEntity;
import com.ariellopes.gestaoescolar.persistence.entity.DisciplinaEntity;
import com.ariellopes.gestaoescolar.rest.controller.domain.dto.AlunoDto;
import com.ariellopes.gestaoescolar.rest.controller.domain.dto.CalculoNotaFinalAlunoDto;
import com.ariellopes.gestaoescolar.rest.controller.domain.dto.CursoDto;
import com.ariellopes.gestaoescolar.rest.controller.domain.dto.EditaAlunoDto;
import com.ariellopes.gestaoescolar.rest.controller.domain.dto.EditaCursoDto;
import com.ariellopes.gestaoescolar.rest.controller.domain.dto.NovaDisciplinaDto;
import com.ariellopes.gestaoescolar.rest.controller.domain.dto.NovoAlunoDto;
import com.ariellopes.gestaoescolar.rest.controller.domain.dto.NovoCursoDto;
import com.ariellopes.gestaoescolar.rest.model.Aluno;
import com.ariellopes.gestaoescolar.rest.model.Curso;
import com.ariellopes.gestaoescolar.rest.model.Disciplina;

@Component
public class AlunoModelMapper {

	public AlunoEntity toEntity(NovoAlunoDto novoAlunoDto) {

		AlunoEntity alunoEntity = new AlunoEntity();

		alunoEntity.setDataCadastro(new Date());
		alunoEntity.setNome(novoAlunoDto.getNome());
		alunoEntity.setEmail(novoAlunoDto.getEmail());
		alunoEntity.setTelefone(novoAlunoDto.getTelefone());
		alunoEntity.setCursoId(novoAlunoDto.getCurso_id());
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
		aluno.setCurso_id(alunoEntity.getCursoId());
		aluno.setTelefone(alunoEntity.getTelefone());
		
		
		return aluno;
	}
	
	public AlunoDto toAlunoDto(AlunoEntity alunoEntity, String nomeCurso) {

		AlunoDto alunoDto = new AlunoDto();
		

		alunoDto.setMatricula(alunoEntity.getMatricula());
		alunoDto.setId(alunoEntity.getId());
		alunoDto.setDataCadastro(alunoEntity.getDataCadastro());
		alunoDto.setNome(alunoEntity.getNome());
		alunoDto.setIdade(alunoEntity.getIdade());
		alunoDto.setEmail(alunoEntity.getEmail());
		alunoDto.setTelefone(alunoEntity.getTelefone());
		alunoDto.setCurso(nomeCurso);
		
		return alunoDto;
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
	
	public CursoEntity toEntityCursoEntity(NovoCursoDto novoCursoDto) {

		CursoEntity cursoEntity = new CursoEntity();
		cursoEntity.setNome(novoCursoDto.getNomeDoCurso());
		cursoEntity.setDescricaoCurso(novoCursoDto.getDescicaoDoCurso());
		
		return cursoEntity;
	}
	
	public Curso toEntityCurso(CursoEntity cursoEntity) {

		Curso curso = new Curso();
		curso.setNome(cursoEntity.getNome());
		curso.setDescricaoCurso(cursoEntity.getDescricaoCurso());
		
		return curso;
	}
	
	public CursoEntity toCurso(EditaCursoDto cursoDto) {

		CursoEntity cursoEntity = new CursoEntity();
		cursoEntity.setId(cursoDto.getId());
		cursoEntity.setNome(cursoDto.getNome());
		cursoEntity.setDescricaoCurso(cursoDto.getDescricaoCurso());
		
		return cursoEntity;
	}
	
	public Curso toCurso(CursoEntity cursoEntity) {

		Curso curso = new Curso();
		curso.setId(cursoEntity.getId());
		curso.setNome(cursoEntity.getNome());
		curso.setDescricaoCurso(cursoEntity.getDescricaoCurso());
		
		return curso;
	}
	
	public CursoDto toCursoDto(Curso curso) {

		CursoDto cursoDto = new CursoDto();
		cursoDto.setId(curso.getId());
		cursoDto.setNome(curso.getNome());
		cursoDto.setDescricaoCurso(curso.getDescricaoCurso());
		
		return cursoDto;
	}
	
	
	public DisciplinaEntity toDisciplinaModel(NovaDisciplinaDto novaDisciplinaDto) {

		DisciplinaEntity disciplinaEntity = new DisciplinaEntity();
		disciplinaEntity.setNomeDisciplina(novaDisciplinaDto.getNomeDisciplina());
		
		return disciplinaEntity;
		
	}
	
	public Disciplina toDisciplina(DisciplinaEntity disciplinaEntity) {

		Disciplina disciplina = new Disciplina();
		disciplina.setNomeDaDisciplina(disciplinaEntity.getNomeDisciplina());
		
		return disciplina;
	}
}
