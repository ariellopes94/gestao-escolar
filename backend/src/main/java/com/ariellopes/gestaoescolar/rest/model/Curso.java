package com.ariellopes.gestaoescolar.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curso {

	private Long id;
	
	private String nome;
	
	private String descricaoCurso;
	
}
