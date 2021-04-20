package com.ariellopes.gestaoescolar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ariellopes.gestaoescolar.persistence.entity.AlunoEntity;
import com.ariellopes.gestaoescolar.persistence.entity.CursoEntity;
import com.ariellopes.gestaoescolar.persistence.entity.DisciplinaEntity;
import com.ariellopes.gestaoescolar.persistence.entity.DisciplinaNotaEntity;
import com.ariellopes.gestaoescolar.persistence.repository.AlunoRepository;
import com.ariellopes.gestaoescolar.persistence.repository.CursoRepository;
import com.ariellopes.gestaoescolar.persistence.repository.DisciplinaNotaRepository;
import com.ariellopes.gestaoescolar.persistence.repository.DisciplinaRepository;
import com.ariellopes.gestaoescolar.rest.model.Aluno;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	
	@Autowired
	private CursoRepository CursoRepository;
	
	@Autowired 
	private DisciplinaRepository disciplinaRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		//ADICIONAR CURSO
		CursoEntity cursoBiologicas = new CursoEntity(1l, "Biológicas", "Biologia é a ciência natural que estuda, descreve,"
											+ " preserva e eventualmente explora economicamente a vida e os organismos vivos.");
		
		CursoEntity cursoExatas = new CursoEntity(2l, "Exatas", "São as ciências que têm a Matemática, a Química e a Física como peças "
											+ "fundamentais dos seus estudos.");
		
		CursoEntity cursoHumanas = new CursoEntity(3l, "Humanas", "As ciências humanas são disciplinas do conhecimento criteriosamente"
											+ " organizados da produção criativa humana.\"");
		
		CursoRepository.saveAll(Arrays.asList(cursoBiologicas, cursoExatas, cursoHumanas));
		
		
		//ADICIONAR DISCIPLINA
		DisciplinaEntity disciplinaBiologica1 = new DisciplinaEntity(1l, "Aerobiologia", cursoBiologicas);
		DisciplinaEntity disciplinaBiologica2 = new DisciplinaEntity(2l, "Anatomia", cursoBiologicas);
		DisciplinaEntity disciplinaBiologica3 = new DisciplinaEntity(3l, "Atropologia", cursoBiologicas);
		
		DisciplinaEntity disciplinaExata1 = new DisciplinaEntity(4l, "Cálculo", cursoExatas);
		DisciplinaEntity disciplinaExata2 = new DisciplinaEntity(5l, "Geomeria", cursoExatas);
		DisciplinaEntity disciplinaExata3 = new DisciplinaEntity(6l, "Trigonometria", cursoExatas);
		
		DisciplinaEntity disciplinaHumana1 = new DisciplinaEntity(7l, "Direto Civíl", cursoHumanas);
		DisciplinaEntity disciplinaHumana2 = new DisciplinaEntity(9l, "Psicologia", cursoHumanas);
		DisciplinaEntity disciplinaHumana3 = new DisciplinaEntity(9l, "Filosofia", cursoHumanas);
		
		disciplinaRepository.saveAll(Arrays.asList(disciplinaBiologica1, disciplinaBiologica2, disciplinaBiologica3,
													disciplinaExata1, disciplinaExata2, disciplinaExata3,
													disciplinaHumana1, disciplinaHumana2, disciplinaHumana3));
		
		
		//ADICIONAR DISCIPLINA NOTA
		DisciplinaNotaEntity disciplinaNota1= new DisciplinaNotaEntity(1l, disciplinaBiologica1, 7d);
		DisciplinaNotaEntity disciplinaNota2 = new DisciplinaNotaEntity(2l, disciplinaBiologica2, 5d);
		DisciplinaNotaEntity disciplinaNota3 = new DisciplinaNotaEntity(3l, disciplinaBiologica3, 10d);
		
		DisciplinaNotaEntity disciplinaNota4 = new DisciplinaNotaEntity(4l, disciplinaExata1, 5d);
		DisciplinaNotaEntity disciplinaNota5 = new DisciplinaNotaEntity(5l, disciplinaExata2, 5.5);
		DisciplinaNotaEntity disciplinaNota6= new DisciplinaNotaEntity(6l, disciplinaExata3, 8d);
		
		DisciplinaNotaEntity disciplinaNota7 = new DisciplinaNotaEntity(7l, disciplinaHumana1, 9d);
		DisciplinaNotaEntity disciplinaNota8 = new DisciplinaNotaEntity(8l, disciplinaHumana2, 6.5);
		DisciplinaNotaEntity disciplinaNota9 = new DisciplinaNotaEntity(9l, disciplinaHumana3, 7d);
		
		//ARRAY DE DISCIPLINA NOTA
		List<DisciplinaNotaEntity> arrayCursoBiologica = new ArrayList<>();
		arrayCursoBiologica.addAll(Arrays.asList(disciplinaNota1, disciplinaNota2, disciplinaNota3));
		
		List<DisciplinaNotaEntity> arrayCursoExata = new ArrayList<>();
		arrayCursoExata.addAll(Arrays.asList(disciplinaNota4, disciplinaNota5, disciplinaNota6));
		
		List<DisciplinaNotaEntity> arrayCursoHumana = new ArrayList<>();
		arrayCursoHumana.addAll(Arrays.asList(disciplinaNota7, disciplinaNota8, disciplinaNota9));
		
		//ADICIONAR ALUNO
		AlunoEntity alunoBiologica = new AlunoEntity(1l, new Date(), "Jaqueline Alvez Peira", 25, "jaqueline.dev@gmail.com", "(67) 99155-8844", arrayCursoBiologica);
		AlunoEntity alunoExata = new AlunoEntity(2l, new Date(), "Miguel Guedes Sobra", 30, "miguel.dev@gmail.com", "(67) 9224-8888", arrayCursoExata);
		AlunoEntity alunoHumana = new AlunoEntity(3l, new Date(), "Chelsea Alcaide Vilante", 25, "chelsea.dev@gmail.com", "(67) 1111-2222", arrayCursoHumana);
		
		alunoRepository.saveAll(Arrays.asList(alunoBiologica, alunoExata, alunoHumana));
	}

}
