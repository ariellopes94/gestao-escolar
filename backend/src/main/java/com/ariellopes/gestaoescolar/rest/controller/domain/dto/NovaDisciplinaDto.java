package com.ariellopes.gestaoescolar.rest.controller.domain.dto;

import com.ariellopes.gestaoescolar.persistence.entity.CursoEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NovaDisciplinaDto {
	
	private String nomeDisciplina;
	
	private CursoEntity cursoEntity;
	
}
