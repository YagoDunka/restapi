package com.example.restapi.controllers;
 
import java.util.ArrayList;
import java.util.List;

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
	
	List<Produto> produtos = new ArrayList<Produto>();
	
	@Autowired
	ProdutoRepository repo;
	
	@GetMapping("/produtos")
	public ResponseEntity<List<Produto>> getProdutos() {
		return ResponseEntity.status(HttpStatus.OK).body(produtos);
	}
	
	@GetMapping("/produtos/{idProduto}")
	public ResponseEntity<Produto> getProduto(@PathVariable("idProduto") int id) {
		Produto prod = null;
		for (Produto pr : produtos) {
			if(pr.getId() == id) {
				prod = pr;
				break;
			}
		}
		if(prod != null)
			return ResponseEntity.status(HttpStatus.OK).body(prod);
		
		return ResponseEntity.status(HttpStatus.OK).body(prod);
	}
	
	@DeleteMapping("/produtos/{idProduto}")
	public ResponseEntity<Boolean> excluirProduto(@PathVariable("idProduto") int id) {
		Produto prod = null;
		for (Produto pr : produtos) {
			if(pr.getId() == id) {
				prod = pr;
				break;
			}
		}
		
		if(prod != null) {
			produtos.remove(prod);
			return ResponseEntity.status(HttpStatus.OK).body(true);
		}
 
		
		return ResponseEntity.status(HttpStatus.OK).body(false);
	}
	
	@PostMapping("/produtos")
	public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) {
		produto.setId(produtos.size()+1);
		produtos.add(produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(produto);
	}
	
	@PutMapping("/produtos/{idProduto}")
	public ResponseEntity<Produto> alterarProduto(@PathVariable("idProduto") int id, @RequestBody Produto produto) {
		Produto prod = null;
		for (Produto pr : produtos) {
			if(pr.getId() == id) {
				prod = pr;
				break;
			}
		}
		if(prod != null) {
			prod.setDescricao(produto.getDescricao());
			prod.setValorUnitario(produto.getValorUnitario());
			prod.setEstoque(produto.getEstoque());
			return ResponseEntity.status(HttpStatus.OK).body(prod);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
 
}