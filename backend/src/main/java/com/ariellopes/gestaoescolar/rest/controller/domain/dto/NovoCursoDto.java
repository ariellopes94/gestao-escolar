package com.ariellopes.gestaoescolar.rest.controller.domain.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class NovoCursoDto implements Serializable{
	private static final long serialVersionUID = 1L;

	private String nomeDoCurso;
	
	private String descicaoDoCurso;
	
}
