package com.generation.LojaDeGames.controller;

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

import com.generation.LojaDeGames.model.Produto;
import com.generation.LojaDeGames.repository.ProdutoRepository;

	@RestController 
	@RequestMapping("/produto")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public class ProdutoController {

		
		@Autowired
		private ProdutoRepository repository;
		
		@GetMapping
		public ResponseEntity<List<Produto>> FindAll() {
			return ResponseEntity.ok(repository.findAll());
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Produto> FindById(@PathVariable Long id) {
			return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		}
		
		@GetMapping("/descricao/{descricao}")
		public ResponseEntity<List<Produto>> FindByTitulo(@PathVariable String descricao) {
			return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
		}
		
		@PostMapping
		public ResponseEntity<Produto> Post(@RequestBody Produto produto) {
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
		}
		
		@PutMapping 
		public ResponseEntity<Produto> Put(@RequestBody Produto produto) {
			return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
		}
		
		@DeleteMapping("/{id}")
		public void Delete(@PathVariable Long id) {
			repository.deleteById(id);
		}
		
}

