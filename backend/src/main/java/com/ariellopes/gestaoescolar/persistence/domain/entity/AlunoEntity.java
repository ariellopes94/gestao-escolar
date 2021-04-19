package com.ariellopes.gestaoescolar.persistence.domain.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "tb_aluno")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date DataCadastro;
	
	private String nome;
	
	private int idade;
	
	private String email;
	
	private String telefone;
	
	
	
}
