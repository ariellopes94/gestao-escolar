package com.ariellopes.gestaoescolar.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name= "tb_disciplina_nota")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DisciplinaNotaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	//@Cascade(CascadeType.ALL)
	private DisciplinaEntity disciplina;
	
	private Double nota;
}
