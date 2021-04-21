package com.ariellopes.gestaoescolar;

import static org.assertj.core.api.Assertions.assertThat;

import javax.validation.ConstraintViolation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ariellopes.gestaoescolar.rest.controller.domain.dto.NovoAlunoDto;
import com.ariellopes.gestaoescolar.rest.model.Aluno;
import com.ariellopes.gestaoescolar.rest.services.AlunoService;

import jdk.jfr.Experimental;

@SpringBootTest
class AlunoIntegrationTests {

	@Autowired
	private AlunoService alunoService;
	
	
	@Test
	public void deveCadastroAlunoComSucesso() {
		// cenário
		NovoAlunoDto novoAluno = new NovoAlunoDto();
		novoAluno.setNome(null);
		novoAluno.setIdade(26);
		novoAluno.setEmail("ariel.dev@gmail.com");
		novoAluno.setTelefone("67 9999-9999");
		
		// ação
		Aluno alunoCriado = alunoService.criar(novoAluno);
		
		// validação
		assertThat(alunoCriado).isNotNull();
		assertThat(alunoCriado.getId()).isNotNull();
	}
	
	@Test
	public void deveFalharAoCadastrarAluno_QuandoSemNome() {
		NovoAlunoDto novoAluno2 = new NovoAlunoDto();
		novoAluno2.setNome(null);
	
		Aluno ent= alunoService.criar(novoAluno2);
	}

}
