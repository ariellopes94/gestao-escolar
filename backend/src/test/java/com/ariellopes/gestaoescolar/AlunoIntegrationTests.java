package com.ariellopes.gestaoescolar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import com.ariellopes.gestaoescolar.exception.model.AlunoNaoEncontradoException;
import com.ariellopes.gestaoescolar.rest.controller.domain.dto.NovoAlunoDto;
import com.ariellopes.gestaoescolar.rest.model.Aluno;
import com.ariellopes.gestaoescolar.rest.services.AlunoService;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AlunoIntegrationTests {

	@Autowired
	private AlunoService alunoService;
	
	@LocalServerPort
	private int port;
	

	@Test
	public void deveCadastrarAlunoComSucesso() {
		
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.given()
			.basePath("/api/constroler-escolar/alunos").
	        contentType(ContentType.JSON)
	    .port(port)
	    .body("{\"nome\" : \"Robert De Niro\",\"idade\": \"26\", \"email\" : \"ariel-lopes.dev.com\", \"telefone\" : \"(67) 991557455\", \"curso_id\": \"2\"}")
	    .post().
	        then()
	     .statusCode(HttpStatus.CREATED.value());
	}
	
	@Test
	public void deveRetornarStatus200_QuandoConsultarAlunos() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		
		RestAssured.given()
			.basePath("/api/constroler-escolar/alunos")
			.port(port)
			.accept(ContentType.JSON)
		.when()
			.get()
		.then()
			.statusCode(HttpStatus.OK.value());
	}


	@Test
	public void deveFalharAoNaoEncontrarAluno_QuandoBuscarPorId() {

		Aluno aluno = new Aluno();
		aluno.setId(547854l);

		Exception exception = assertThrows(AlunoNaoEncontradoException.class, () -> {
			alunoService.buscarPorId(aluno.getId());
		});

			String expectedMessage = "Aluno não encontrado";
		    String actualMessage = exception.getMessage();

		   assertTrue(actualMessage.contains(expectedMessage));
	}

}
