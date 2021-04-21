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

import com.ariellopes.gestaoescolar.rest.controller.domain.dto.CalculoNotaFinalAlunoDto;
import com.ariellopes.gestaoescolar.rest.controller.domain.dto.EditaAlunoDto;
import com.ariellopes.gestaoescolar.rest.controller.domain.dto.NovaDisciplinaDto;
import com.ariellopes.gestaoescolar.rest.controller.domain.dto.NovoAlunoDto;
import com.ariellopes.gestaoescolar.rest.model.Aluno;
import com.ariellopes.gestaoescolar.rest.model.Disciplina;
import com.ariellopes.gestaoescolar.rest.services.AlunoService;
import com.ariellopes.gestaoescolar.rest.services.CursoService;
import com.ariellopes.gestaoescolar.rest.services.DisciplinaService;

@RestController
@RequestMapping("api/constroler-escolar/disciplinas")
public class DisciplinaController {

	@Autowired
	private DisciplinaService disciplinaService;
	

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Disciplina> criar(@Valid @RequestBody NovaDisciplinaDto novaDisciplinaDto) {

		Disciplina disciplina = disciplinaService.criar(novaDisciplinaDto);

		URI uri = ServletUriComponentsBuilder.
					fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(disciplina.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
}
