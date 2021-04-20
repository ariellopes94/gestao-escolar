package com.ariellopes.gestaoescolar.persistence.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ariellopes.gestaoescolar.rest.model.enuns.CursoEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "tb_disciplina")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisciplinaEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nomeDisciplina;
	
	@OneToOne
	private CursoEntity cursoEntity;

}
