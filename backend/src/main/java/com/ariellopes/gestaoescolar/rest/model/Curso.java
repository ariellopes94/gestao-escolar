package com.ariellopes.gestaoescolar.rest.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.OneToMany;

import com.ariellopes.gestaoescolar.persistence.entity.DisciplinaEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curso {

	private Long id;
	
	private String nomeDoCurso;
	
	private String descicaoDoCurso;
	
	private Long alunoId;
	
	@OneToMany
	private List<DisciplinaEntity> disciplinas = new ArrayList<>();
}
