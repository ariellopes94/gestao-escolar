package com.ariellopes.gestaoescolar.persistence.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

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
	
	private Integer idade;
	
	private String email;
	
	private String telefone;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	private List<DisciplinaNotaEntity> matricula = new ArrayList<>();
}
