package br.edu.senaisp.colegio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.senaisp.colegio.model.Disciplina;
import br.edu.senaisp.colegio.repository.DisciplinaRepository;

@Service
public class DisciplinaService {
	
	@Autowired
	private DisciplinaRepository repoDisciplina;
	
	public Disciplina gravarDisciplina(Disciplina a) {
		return repoDisciplina.save(a);
	}
	

	public List<Disciplina> buscarTodos() {
		return repoDisciplina.findAll();
	}

	public Disciplina buscarPorId(Long id) {
		Optional<Disciplina> op = repoDisciplina.findById(id);
		return op.orElseThrow(() -> new RuntimeException("Usuário não existe"));
	}

	public Disciplina alterarDisciplina(Long id, Disciplina a) {
		Optional<Disciplina> op = repoDisciplina.findById(id);
		
		if(op.isPresent()) {
			a.setId(id);
			return repoDisciplina.save(a);
		}else
		return null;
	}

	public Disciplina excluirPorId(Long id) {
		try {
			Disciplina a = buscarPorId(id);
			if (a != null) {
				repoDisciplina.deleteById(id);
				return a;
			}
			
		} catch (Exception e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}
		
		return null;
	}

}
