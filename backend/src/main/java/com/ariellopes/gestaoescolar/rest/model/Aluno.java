package com.ariellopes.gestaoescolar.rest.model;



import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {

	private Long id;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date dataCadastro;

	private String nome;

	private Integer idade;

	private String email;

	private String telefone;
}
