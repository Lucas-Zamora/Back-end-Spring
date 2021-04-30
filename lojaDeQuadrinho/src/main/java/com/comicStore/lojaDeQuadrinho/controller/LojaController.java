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

import com.comicStore.lojaDeQuadrinho.model.Loja;
import com.comicStore.lojaDeQuadrinho.repository.LojaRepository;
import com.comicStore.lojaDeQuadrinho.service.LojaService;

@RestController
@RequestMapping("/loja")
@CrossOrigin("*")
public class LojaController {

	@Autowired
	public LojaRepository repository;
	
	@Autowired
	public LojaService service;

	@GetMapping
	public ResponseEntity<List<Loja>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id_loja")
	public ResponseEntity<Loja> getById(@PathVariable long id_loja) {
		return repository.findById(id_loja).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Loja> post(@RequestBody Loja loja) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(loja));
	}
	
	/*
     * EXPLICACAO URI:
     * 
     *     /inscricao -> nome da tabela associativa
     *     /usuarios -> nome da lista de jogos dentro da classe Loja
     *     /lojas -> nome da lista de plataformas dentro da classe Usuario
     * 
     * */
	@PutMapping("/inscricao/usuarios/{id_loja}/lojas/{id_usuario}")
	public ResponseEntity<Loja> putLojaUsuario (@PathVariable long id_loja, @PathVariable long id_usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastroUsuarioLoja(id_loja, id_usuario));
	}
	

	@PutMapping
	public ResponseEntity<Loja> put(@RequestBody Loja loja) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(loja));
	}

	@DeleteMapping
	public void delete(@PathVariable long id_loja) {
		repository.deleteById(id_loja);
	}

}