package com.ariellopes.gestaoescolar.rest.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {

	private Long id;

	private Date DataCadastro;

	private String nome;

	private int idade;

	private String email;

	private String telefone;
}
