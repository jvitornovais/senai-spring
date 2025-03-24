package br.edu.senaisp.colegio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.senaisp.colegio.model.Aluno;
import br.edu.senaisp.colegio.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repo;
	
	public Aluno gravarAluno(Aluno a) {
		return repo.save(a);
	}

}
