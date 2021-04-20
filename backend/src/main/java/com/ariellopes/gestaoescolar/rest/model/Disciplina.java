package com.ariellopes.gestaoescolar.rest.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Disciplina implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nomeDaDisciplina;

	
	private Curso cursoEntity;
}
