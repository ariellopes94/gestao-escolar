package com.ariellopes.gestaoescolar.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.ariellopes.gestaoescolar.persistence.entity.AlunoEntity;
import com.ariellopes.gestaoescolar.persistence.entity.CursoEntity;
import com.ariellopes.gestaoescolar.persistence.entity.DisciplinaEntity;
import com.ariellopes.gestaoescolar.persistence.entity.DisciplinaNotaEntity;
import com.ariellopes.gestaoescolar.persistence.repository.AlunoRepository;
import com.ariellopes.gestaoescolar.persistence.repository.CursoRepository;
import com.ariellopes.gestaoescolar.persistence.repository.DisciplinaRepository;

@Service
public class DBService {

	@Autowired
	private CursoRepository CursoRepository;

	@Autowired
	private DisciplinaRepository disciplinaRepository;

	@Autowired
	private AlunoRepository alunoRepository;

	public void instantiateTestDatabase() throws ParseException {
		// ADICIONAR CURSO
		CursoEntity cursoBiologicas = new CursoEntity(1l, "Biológicas",
				"Biologia é a ciência natural que estuda, descreve,"
						+ " preserva e eventualmente explora economicamente a vida e os organismos vivos.");

		CursoEntity cursoExatas = new CursoEntity(2l, "Exatas",
				"São as ciências que têm a Matemática, a Química e a Física como peças "
						+ "fundamentais dos seus estudos.");

		CursoEntity cursoHumanas = new CursoEntity(3l, "Humanas",
				"As ciências humanas são disciplinas do conhecimento criteriosamente"
						+ " organizados da produção criativa humana.\"");

		CursoRepository.saveAll(Arrays.asList(cursoBiologicas, cursoExatas, cursoHumanas));

		// ADICIONAR DISCIPLINA
		DisciplinaEntity disciplinaBiologica1 = new DisciplinaEntity(1l, "Aerobiologia", cursoBiologicas);
		DisciplinaEntity disciplinaBiologica2 = new DisciplinaEntity(2l, "Anatomia", cursoBiologicas);
		DisciplinaEntity disciplinaBiologica3 = new DisciplinaEntity(3l, "Atropologia", cursoBiologicas);

		DisciplinaEntity disciplinaExata1 = new DisciplinaEntity(4l, "Cálculo", cursoExatas);
		DisciplinaEntity disciplinaExata2 = new DisciplinaEntity(5l, "Geomeria", cursoExatas);
		DisciplinaEntity disciplinaExata3 = new DisciplinaEntity(6l, "Trigonometria", cursoExatas);

		DisciplinaEntity disciplinaHumana1 = new DisciplinaEntity(7l, "Direto Civíl", cursoHumanas);
		DisciplinaEntity disciplinaHumana2 = new DisciplinaEntity(8l, "Psicologia", cursoHumanas);
		DisciplinaEntity disciplinaHumana3 = new DisciplinaEntity(9l, "Filosofia", cursoHumanas);

		DisciplinaEntity disciplinaExata4 = new DisciplinaEntity(10l, "Álgebra Linear.", cursoExatas);
		DisciplinaEntity disciplinaExata5 = new DisciplinaEntity(11l, "Arquitetura de Computadores", cursoExatas);
		DisciplinaEntity disciplinaExata6 = new DisciplinaEntity(12l, "Circuitos Digitais e Elétricos", cursoExatas);

		disciplinaRepository.saveAll(Arrays.asList(disciplinaBiologica1, disciplinaBiologica2, disciplinaBiologica3,
				disciplinaExata1, disciplinaExata2, disciplinaExata3, disciplinaHumana1, disciplinaHumana2,
				disciplinaHumana3, disciplinaExata4, disciplinaExata5, disciplinaExata6));

		// ADICIONAR DISCIPLINA NOTA
		DisciplinaNotaEntity disciplinaNota1 = new DisciplinaNotaEntity(1l, disciplinaBiologica1, 7d);
		DisciplinaNotaEntity disciplinaNota2 = new DisciplinaNotaEntity(2l, disciplinaBiologica2, 5d);
		DisciplinaNotaEntity disciplinaNota3 = new DisciplinaNotaEntity(3l, disciplinaBiologica3, 10d);

		DisciplinaNotaEntity disciplinaNota4 = new DisciplinaNotaEntity(4l, disciplinaExata1, 5d);
		DisciplinaNotaEntity disciplinaNota5 = new DisciplinaNotaEntity(5l, disciplinaExata2, 5.5);
		DisciplinaNotaEntity disciplinaNota6 = new DisciplinaNotaEntity(6l, disciplinaExata3, 8d);

		DisciplinaNotaEntity disciplinaNota7 = new DisciplinaNotaEntity(7l, disciplinaHumana1, 9d);
		DisciplinaNotaEntity disciplinaNota8 = new DisciplinaNotaEntity(8l, disciplinaHumana2, 6.5);
		DisciplinaNotaEntity disciplinaNota9 = new DisciplinaNotaEntity(9l, disciplinaHumana3, 7d);

		DisciplinaNotaEntity disciplinaNota10 = new DisciplinaNotaEntity(10l, disciplinaExata4, 4d);
		DisciplinaNotaEntity disciplinaNota11 = new DisciplinaNotaEntity(11l, disciplinaExata5, 8.5);
		DisciplinaNotaEntity disciplinaNota12 = new DisciplinaNotaEntity(12l, disciplinaExata6, 5.5d);

		// ARRAY DE DISCIPLINA NOTA
		List<DisciplinaNotaEntity> arrayCursoBiologica = new ArrayList<>();
		arrayCursoBiologica.addAll(Arrays.asList(disciplinaNota1, disciplinaNota2, disciplinaNota3));

		List<DisciplinaNotaEntity> arrayCursoExata1 = new ArrayList<>();
		arrayCursoExata1.addAll(Arrays.asList(disciplinaNota4, disciplinaNota5, disciplinaNota6));

		List<DisciplinaNotaEntity> arrayCursoHumana = new ArrayList<>();
		arrayCursoHumana.addAll(Arrays.asList(disciplinaNota7, disciplinaNota8, disciplinaNota9));

		List<DisciplinaNotaEntity> arrayCursoExata2 = new ArrayList<>();
		arrayCursoExata2.addAll(Arrays.asList(disciplinaNota10, disciplinaNota11, disciplinaNota12));

		// ADICIONAR ALUNO
		AlunoEntity alunoBiologica = new AlunoEntity(1l, new Date(), "Jaqueline Alvez Peira", 25,
				"jaqueline.dev@gmail.com", "(67) 99155-8844", 1l, arrayCursoBiologica);
		AlunoEntity alunoExata1 = new AlunoEntity(2l, new Date(), "Miguel Guedes Sobra", 30, "miguel.dev@gmail.com",
				"(67) 9224-8888", 2l, arrayCursoExata1);
		AlunoEntity alunoHumana = new AlunoEntity(3l, new Date(), "Chelsea Alcaide Vilante", 25,
				"chelsea.dev@gmail.com", "(67) 1111-2222", 3l, arrayCursoHumana);
		AlunoEntity alunoExata2 = new AlunoEntity(4l, new Date(), "Eleonor Perdigão Rios", 27, "eleonor.dev@gmail.com",
				"(67) 1111-2222", 2l, arrayCursoExata2);

		alunoRepository.saveAll(Arrays.asList(alunoBiologica, alunoExata1, alunoHumana, alunoExata2));

	}

}
