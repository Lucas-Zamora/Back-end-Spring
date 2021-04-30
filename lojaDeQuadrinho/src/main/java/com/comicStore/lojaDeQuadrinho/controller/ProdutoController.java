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

import com.comicStore.lojaDeQuadrinho.model.Produto;
import com.comicStore.lojaDeQuadrinho.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
@CrossOrigin("*")
public class ProdutoController {

	@Autowired
	public ProdutoRepository repository;

	@GetMapping
	public ResponseEntity<List<Produto>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> getById(@PathVariable long id_produto) {
		return repository.findById(id_produto).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Produto>> getByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}

	@GetMapping("/precoMenor/{preco}")
	public ResponseEntity<List<Produto>> getByPrecoMenor(@PathVariable double preco) {
		return ResponseEntity.ok(repository.findAllByPrecoLessThanEqual(preco));
	}

	@GetMapping("/precoMaior/{preco}")
	public ResponseEntity<List<Produto>> getByPrecoMaior(@PathVariable double preco) {
		return ResponseEntity.ok(repository.findAllByPrecoGreaterThanEqual(preco));
	}

	@GetMapping("/preco/{preco}")
	public ResponseEntity<List<Produto>> getByPreco(@PathVariable double preco) {
		return ResponseEntity.ok(repository.findAllByPreco(preco));
	}

	@PostMapping
	public ResponseEntity<Produto> post(@RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}

	@PutMapping
	public ResponseEntity<Produto> put(@RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}

	@DeleteMapping
	public void delete(@PathVariable long id_produto) {
		repository.deleteById(id_produto);
	}

}
