package com.ariellopes.gestaoescolar.rest.controller.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NovoAlunoDto {


	@Size(max = 255,message = "descricao ultrapassou 255 caracteres")
	@NotBlank(message = "campo descricao nao pode ser vazio")
	@NotNull(message = "campo descricao nao pode ser nulo")
	private String nome;

	 @NotNull(message = "Volume é obrigatório em mL")
	private Integer idade;

	@Size(max = 255,message = "descricao ultrapassou 255 caracteres")
	@NotBlank(message = "campo descricao nao pode ser vazio")
	@NotNull(message = "campo descricao nao pode ser nulo")
	private String email;

	@Size(max = 255,message = "descricao ultrapassou 255 caracteres")
	@NotBlank(message = "campo descricao nao pode ser vazio")
	@NotNull(message = "campo descricao nao pode ser nulo")
	private String telefone;
}
