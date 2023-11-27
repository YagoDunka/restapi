package com.example.restapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {
	
	@GetMapping("/produtos")
	public String getProdutos() {
		return "produtos";
	}
	
	@PostMapping("/produtos")
	public String salvarProduto(@RequestBody String contato) {
		return contato;
	}

}
