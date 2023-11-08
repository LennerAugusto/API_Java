package com.projeto.models.data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProdutoRequest {
	
	private Long produtoId;
	private String nomeProduto;
	private String preco;
	
	@NotBlank
	@NotNull
	public Long getProdutoId() {
		return produtoId;
	}
	
	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}
	
	@NotBlank
	@NotNull
	public String getNomeProduto() {
		return nomeProduto;
	}
	
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	
	@NotBlank
	@NotNull
	public String getPreco() {
		return preco;
	}
	
	public void setPreco(String preco) {
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		return "ClienteResquest [Id=" + produtoId + ", Nome do produto=  " +  "Preço=  " + preco;
	}
	
}
