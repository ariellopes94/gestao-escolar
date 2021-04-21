package com.ariellopes.gestaoescolar.rest.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ariellopes.gestaoescolar.rest.controller.domain.dto.CursoDto;
import com.ariellopes.gestaoescolar.rest.controller.domain.dto.EditaCursoDto;
import com.ariellopes.gestaoescolar.rest.controller.domain.dto.NovoCursoDto;
import com.ariellopes.gestaoescolar.rest.model.Aluno;
import com.ariellopes.gestaoescolar.rest.model.Curso;
import com.ariellopes.gestaoescolar.rest.services.CursoService;

@RestController
@RequestMapping("api/constroler-escolar/cursos")
public class CursoController {

	@Autowired
	private CursoService cursoService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Aluno> criar(@Valid @RequestBody NovoCursoDto novoCursoDto) {

		Curso curso = cursoService.criar(novoCursoDto);

		URI uri = ServletUriComponentsBuilder.
					fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(curso.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Curso> editar(@Valid @RequestBody EditaCursoDto curso , @PathVariable Long id){
	
		cursoService.editar(curso, id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Curso> findById(@PathVariable Long id){
		 Curso obj = cursoService.buscarPorId(id);
		 return ResponseEntity.ok().body(obj);
	} 
	
	@GetMapping
	public Page<Curso> buscarTodos(
			@PageableDefault(size = 5, sort = "nome", direction = Direction.DESC) Pageable pageable) {
		Page<Curso> cursoPage = cursoService.buscarTodos(pageable);

		List<Curso> cursoModel = cursoPage.getContent();
		Page<Curso> cursoModelPage = new PageImpl<>(cursoModel, pageable,
				cursoPage.getTotalElements());
		return cursoModelPage;
	}
	
	@GetMapping("/filtro/quantidade/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<CursoDto> matriculasNoCurso(@PathVariable Long id) {
		CursoDto obj = cursoService.qtAlunoNoCursoAreaEspetifica(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
