package com.example.restapi.controllers;
 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.entities.Categoria;
import com.example.restapi.entities.Produto;
import com.example.restapi.repositories.CategoriaRepository;
 
@RestController
public class CategoriaController {
	
	@Autowired
	CategoriaRepository repo;
	
	@GetMapping("/categoria")
	public ResponseEntity<List<Categoria>> buscarCategoria() {
		return ResponseEntity.status(HttpStatus.OK).body(repo.findAll());
	}
	
	@GetMapping("/categoria/{idCategoria}")
	public ResponseEntity<Categoria> buscarCategorias(@PathVariable("idCategoria") long id) {
		Optional<Categoria> opt = repo.findById(id);
		try {
			Categoria cat = opt.get();
			return ResponseEntity.status(HttpStatus.OK).body(cat);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}	
	}
	
	@DeleteMapping("/categoria/{idCategoria}")
	public ResponseEntity<Boolean> ExcluirCategoria(@PathVariable("idCategoria") long id) {
		Optional<Categoria> opt = repo.findById(id);
		try {
			Categoria cat = opt.get();
			repo.delete(cat);
			return ResponseEntity.status(HttpStatus.OK).body(true);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);	
		}
	}
	
	@PostMapping("/categoria")
	public ResponseEntity<Categoria> salverCategoria(@RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(categoria));
	}
	
	@PutMapping("/categoria/{idCategoria}")
	public ResponseEntity<Categoria> editarCategoria(@PathVariable("idCategoria") long id, @RequestBody Categoria categori) {
		Optional<Categoria> opt = repo.findById(id);
		try {
			Categoria categoria = opt.get();
			categoria.setNome(categori.getDescricao());
			categoria.setStatus(categori.getStatus());
			return ResponseEntity.status(HttpStatus.OK).body(categoria);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);	
		}
	}
	
	@PatchMapping("/categoria/{idCategoria}")
	public ResponseEntity<Categoria> desativarCategoria(@PathVariable("idCategoria") long id, @RequestBody Categoria categori) {
		Optional<Categoria> opt = repo.findById(id);
		try {
			Categoria categoria = opt.get();
			categoria.setStatus(categori.getStatus());
			return ResponseEntity.status(HttpStatus.OK).body(categoria);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.CREATED).body(null);
		}
		
		
	}
}