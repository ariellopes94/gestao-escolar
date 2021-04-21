package com.ariellopes.gestaoescolar.rest.controller.domain.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculoNotaFinalAlunoDto {

	private Long id;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date dataCadastro;

	private String nome;

	private Integer idade;

	private String email;

	private String telefone;
	
	private String notaFinal;
	
	private String situacao;
	

	
}
