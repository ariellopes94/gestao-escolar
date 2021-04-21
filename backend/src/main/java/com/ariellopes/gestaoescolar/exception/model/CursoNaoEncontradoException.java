package com.ariellopes.gestaoescolar.exception.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CursoNaoEncontradoException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public CursoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public CursoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}