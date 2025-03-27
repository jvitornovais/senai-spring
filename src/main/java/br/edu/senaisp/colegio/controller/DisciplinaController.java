package br.edu.senaisp.colegio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.senaisp.colegio.model.Disciplina;
import br.edu.senaisp.colegio.service.DisciplinaService;

@RestController
@RequestMapping("/api/disciplina")
public class DisciplinaController {
	
	@Autowired
	private DisciplinaService DisciplinaService; 
	
	@GetMapping
	public ResponseEntity buscarTodos() {
		return ResponseEntity.ok(DisciplinaService.buscarTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity buscarPorId(
			@PathVariable Long id) {
		try {
			Disciplina a = DisciplinaService.buscarPorId(id);
			
			if(a == null)
				return ResponseEntity.notFound().build();
			else
				return ResponseEntity.ok(a);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		
	} 
	
	@PostMapping
	public ResponseEntity inserir(
			@RequestBody Disciplina a) {
		
		try {
			return ResponseEntity.ok(
					DisciplinaService.gravarDisciplina(a)
					);
		} catch (Exception e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}

	}
	
	@PutMapping("/{id}")
	public ResponseEntity alterar(
			@PathVariable Long id,
			@RequestBody Disciplina a
			) {
		return ResponseEntity.ok(DisciplinaService.alterarDisciplina(id, a));
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity excluir(
			@PathVariable Long id) {
		try {
			Disciplina a = DisciplinaService.excluirPorId(id);
			
			if (a == null)
				return ResponseEntity.notFound().build();
			else
				return ResponseEntity.ok(a);			
			
		} catch (Exception e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}
	}	

}
