package com.example.restapi.entities;
 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
 
@Entity
public class Produto {
 
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private Long id;
	private String descricao;
	@Column(name = "preco")
	private double valorUnitario;
	private double estoque;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getValorUnitario() {
		return valorUnitario;
	}
	
	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	public double getEstoque() {
		return estoque;
	}
	
	public void setEstoque(double stoque) {
		this.estoque = stoque;
	}
}