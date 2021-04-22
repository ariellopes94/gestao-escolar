package com.ariellopes.gestaoescolar.exception.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ariellopes.gestaoescolar.exception.handler.validation.StandardError;
import com.ariellopes.gestaoescolar.exception.handler.validation.ValidationError;
import com.ariellopes.gestaoescolar.exception.model.AlunoNaoEncontradoException;
import com.ariellopes.gestaoescolar.exception.model.CursoNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e,
			                                                            HttpServletRequest request){
	
		ValidationError erro = new ValidationError();
		
	   for(FieldError x : e.getBindingResult().getFieldErrors()) {
		   erro.addError(x.getField(), x.getDefaultMessage());
	   }
			
			
	    erro.setTimestamp(System.currentTimeMillis());
		erro.setStatus(422);
		erro.setError("Erro de Validação");
		erro.setMessage(e.getMessage());
		erro.setPath(request.getRequestURI());
		erro.setMensagemDesenvolvedor("http://erros.sistemagestaoescolar.com/422");
		
		
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(erro);
	}
	
	@ExceptionHandler(AlunoNaoEncontradoException.class)
	public ResponseEntity<StandardError> handlerObjectNotFoundException(AlunoNaoEncontradoException e,
			                                                            HttpServletRequest request){
		StandardError erro = new StandardError();
		
		erro.setTimestamp(System.currentTimeMillis());
		erro.setStatus(404);
		erro.setError("Aluno Não encontrado");
		erro.setMessage(e.getMessage());
		erro.setPath(request.getRequestURI());
		erro.setMensagemDesenvolvedor("http://erros.sistemagestaoescolar.com/404");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(CursoNaoEncontradoException.class)
	public ResponseEntity<StandardError> handlerObjectNotFoundException(CursoNaoEncontradoException e,
			                                                            HttpServletRequest request){
		StandardError erro = new StandardError();
		
		erro.setTimestamp(System.currentTimeMillis());
		erro.setStatus(404);
		erro.setError("Curso Não encontrado");
		erro.setMessage(e.getMessage());
		erro.setPath(request.getRequestURI());
		erro.setMensagemDesenvolvedor("http://erros.sistemagestaoescolar.com/404");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
}
