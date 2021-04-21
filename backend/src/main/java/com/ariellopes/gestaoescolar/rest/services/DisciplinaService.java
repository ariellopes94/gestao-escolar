package com.ariellopes.gestaoescolar.rest.services;

import java.util.List;

import com.ariellopes.gestaoescolar.rest.controller.domain.dto.NovaDisciplinaDto;
import com.ariellopes.gestaoescolar.rest.model.Disciplina;

public interface DisciplinaService {

	
	public Disciplina criar(NovaDisciplinaDto novaDisciplinaDto);
	
}
