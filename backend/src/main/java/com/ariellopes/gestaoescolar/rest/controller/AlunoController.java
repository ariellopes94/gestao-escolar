package com.ariellopes.gestaoescolar.rest.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ariellopes.gestaoescolar.rest.controller.domain.dto.AlunoDto;
import com.ariellopes.gestaoescolar.rest.controller.domain.dto.CalculoNotaFinalAlunoDto;
import com.ariellopes.gestaoescolar.rest.controller.domain.dto.EditaAlunoDto;
import com.ariellopes.gestaoescolar.rest.controller.domain.dto.NovoAlunoDto;
import com.ariellopes.gestaoescolar.rest.model.Aluno;
import com.ariellopes.gestaoescolar.rest.services.AlunoService;

@RestController
@RequestMapping("api/constroler-escolar/alunos")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;
	

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Aluno> criar(@Validated @RequestBody NovoAlunoDto novoAlunoDto) {

		Aluno aluno = alunoService.criar(novoAlunoDto);

		URI uri = ServletUriComponentsBuilder.
					fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(aluno.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Aluno> editar(@Validated @RequestBody EditaAlunoDto aluno , @PathVariable Long id){
	
		alunoService.editar(aluno, id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> delete(@PathVariable Long id){
		alunoService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<AlunoDto> findById(@PathVariable Long id){
		 AlunoDto obj = alunoService.buscarPorIdPersonalizado(id);
		 return ResponseEntity.ok().body(obj);
	} 
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Page<Aluno> buscarTodos(
			@PageableDefault(size = 5, sort = "nome", direction = Direction.DESC) Pageable pageable) {
		Page<Aluno> publicacaoPage = alunoService.buscarTodos(pageable);

		List<Aluno> publicacaoModel = publicacaoPage.getContent();
		Page<Aluno> publicacaoModelPage = new PageImpl<>(publicacaoModel, pageable,
				publicacaoPage.getTotalElements());
		return publicacaoModelPage;
	}
	
	@GetMapping(value = "/calcula/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<CalculoNotaFinalAlunoDto> calcularNota(@PathVariable Long id){
		 CalculoNotaFinalAlunoDto obj = alunoService.calcularNota(id);
		 return ResponseEntity.ok().body(obj);
	} 
	
	
}
