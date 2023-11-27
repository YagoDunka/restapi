package com.example.restapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {
	
	@GetMapping("/produtos")
	public String getProdutos() {
		return "produtos";
	}

}
