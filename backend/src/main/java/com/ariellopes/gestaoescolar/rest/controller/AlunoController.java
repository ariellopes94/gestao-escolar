package com.ariellopes.gestaoescolar.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/constroler-escolar/alunos")
public class AlunoController {

	@GetMapping
	public String testandoRest(){
		
		return "Hello World";
	}
}
