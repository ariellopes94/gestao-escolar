package com.ariellopes.gestaoescolar.exception.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AlunoNaoEncontradoException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public AlunoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public AlunoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}