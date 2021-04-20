package com.ariellopes.gestaoescolar.rest.model.enuns;

import lombok.Getter;

@Getter
public enum CursoEnum {

	BIOLOGICAS(1, "Biológicas", "Biológicas', 'Biologia é a ciência natural que estuda, descreve, preserva e eventualmente explora economicamente a vida e os organismos vivos."),
	EXATAS(2, "Ciências exatas", "São as ciências que têm a Matemática, a Química e a Física como peças fundamentais dos seus estudos."),
	HUMANAS(3, "Humanas", "Humanas', 'As ciências humanas são disciplinas do conhecimento criteriosamente organizados da produção criativa humana.");
	
	private int cod;
	private String curso;
	private String descricao;
	
	
	private CursoEnum(int cod, String curso, String descricao) {
		this.cod = cod;
		this.curso = curso;
		this.descricao = descricao;
	}
	
	
	public static CursoEnum toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}
		for (CursoEnum x : CursoEnum.values()) {

			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalAccessError("ID ivalido" + cod);
	}
}
