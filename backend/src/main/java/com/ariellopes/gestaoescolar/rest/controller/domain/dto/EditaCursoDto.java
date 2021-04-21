package com.ariellopes.gestaoescolar.rest.controller.domain.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditaCursoDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nome;
	
	private String descricaoCurso;
}
