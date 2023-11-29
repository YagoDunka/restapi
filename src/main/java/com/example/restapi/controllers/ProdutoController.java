package com.example.restapi.controllers;
 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.entities.Produto;
import com.example.restapi.repositories.ProdutoRepository;
 
@RestController
public class ProdutoController {
	@Autowired
	ProdutoRepository repo;
	@GetMapping("/produtos")
	public ResponseEntity<List<Produto>> getProdutos() {
		return ResponseEntity.status(HttpStatus.OK).body(repo.findAll());
	}
	@GetMapping("/produtos/{idProduto}")
	public ResponseEntity<Produto> getProduto(@PathVariable("idProduto") Long id) {
		Optional<Produto> opt = repo.findById(id);
		try {
			Produto prod = opt.get();
			return ResponseEntity.status(HttpStatus.OK).body(prod);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	@DeleteMapping("/produtos/{idProduto}")
	public ResponseEntity<Boolean> excluirProduto(@PathVariable("idProduto") Long id) {
		Optional<Produto> opt = repo.findById(id);
		try {
			Produto prod = opt.get();
		    repo.delete(prod);
			return ResponseEntity.status(HttpStatus.OK).body(true);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
		}
	}
	@PostMapping("/produtos")
	public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(produto));
	}
	@PutMapping("/produtos/{idProduto}")
	public ResponseEntity<Produto> editarProduto(@PathVariable("idProduto") Long id, @RequestBody Produto produto) {
			Optional<Produto> opt = repo.findById(id);
		try {
			Produto prod = opt.get();
			prod.setDescricao(produto.getDescricao());
			prod.setEstoque(produto.getEstoque());
			prod.setValorUnitario(produto.getValorUnitario());
			repo.save(prod);
			return ResponseEntity.status(HttpStatus.OK).body(prod);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
}