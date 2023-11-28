package com.example.restapi.controllers;
 
import java.util.ArrayList;
import java.util.List;
 
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
 
@RestController
public class CategoriaController {
List<Categoria> categorias = new ArrayList<Categoria>();
	
	@GetMapping("/categoria")
	public ResponseEntity<List<Categoria>> buscarCategoria() {
		return ResponseEntity.status(HttpStatus.OK).body(categorias);
	}
	
	@GetMapping("/categoria/{idCategoria}")
	public ResponseEntity<Categoria> buscarCategorias(@PathVariable("idCategoria") int id) {
		Categoria cat = null;
		for (Categoria pr : categorias) {
			if(pr.getId() == id) {
				cat = pr;
				break;
			}
		}
		if(cat != null)
			return ResponseEntity.status(HttpStatus.OK).body(cat);
		
		return ResponseEntity.status(HttpStatus.OK).body(cat);
	}
	
	@DeleteMapping("/categoria/{idCategoria}")
	public ResponseEntity<Boolean> ExcluirCategoria(@PathVariable("idCategoria") int id) {
		Categoria prod = null;
		for (Categoria pr : categorias) {
			if(pr.getId() == id) {
				prod = pr;
				break;
			}
		}
		
		if(prod != null) {
			categorias.remove(prod);
			return ResponseEntity.status(HttpStatus.OK).body(true);
		}
 
		
		return ResponseEntity.status(HttpStatus.OK).body(false);
	}
	
	@PostMapping("/categoria")
	public ResponseEntity<Categoria> salverCategoria(@RequestBody Categoria categoria) {
		categoria.setId(categorias.size()+1);
		categorias.add(categoria);
		return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
	}
	
	@PutMapping("/categoria/{idCategoria}")
	public ResponseEntity<Categoria> editarCategoria(@PathVariable("idCategoria") int id, @RequestBody Categoria categori) {
		
		Categoria categoria = null;
		for (Categoria cat : categorias) {
			if(cat.getId() == id) {
				categoria = cat;
				break;
			}
		}
		
		if(categoria != null) {
			categoria.setNome(categori.getNome());
			categoria.setStatus(categori.getStatus());
			return ResponseEntity.status(HttpStatus.OK).body(categoria);
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
	}
	
	@PatchMapping("/categoria/{idCategoria}")
	public ResponseEntity<Categoria> desativarCategoria(@PathVariable("idCategoria") int id, @RequestBody Categoria categori) {
		
		Categoria categoria = null;
		for (Categoria cat : categorias) {
			if(cat.getId() == id) {
				categoria = cat;
				break;
			}
		}
		
		if(categoria != null) {
			categoria.setStatus(categori.getStatus());
			return ResponseEntity.status(HttpStatus.OK).body(categoria);
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
	}
}