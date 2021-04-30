package com.comicStore.lojaDeQuadrinho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comicStore.lojaDeQuadrinho.model.Editora;
import com.comicStore.lojaDeQuadrinho.repository.EditoraRepository;

@RestController
@RequestMapping("/editora")
@CrossOrigin("*")
public class EditoraController {

	@Autowired
	public EditoraRepository repository;

	@GetMapping
	public ResponseEntity<List<Editora>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id_editora")
	public ResponseEntity<Editora> getById(@PathVariable long id_editora) {
		return repository.findById(id_editora).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	/*@GetMapping("/nomeEditora/{nomeEditora}")
	public ResponseEntity<List<Editora>> getByNomeEditora(@PathVariable String nomeEditora) {
		return ResponseEntity.ok(repository.findAllByNomeEditoraContainingIgnoreCase(nomeEditora));
	}*/

	@PostMapping
	public ResponseEntity<Editora> post(@RequestBody Editora editora) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(editora));
	}

	@PutMapping
	public ResponseEntity<Editora> put(@RequestBody Editora editora) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(editora));
	}

	@DeleteMapping
	public void delete(@PathVariable long id_editora) {
		repository.deleteById(id_editora);
	}
}
