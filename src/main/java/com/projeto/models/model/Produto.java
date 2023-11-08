package com.projeto.models.model;


import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.projeto.models.pk.PrimaryKey;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name = "TAB_PRODUTO")
public class Produto extends PrimaryKey implements Serializable{

	private static final long serialVersionUID = -2374616540565822199L;

	private String  nomeProduto;
	private Float preco; 
	private String contentType;
	
	private boolean ativo;
	
	public Produto() {
	}

	
    public Produto(String nomeProduto, float preco,
			String contentType) {
		super();
		this.nomeProduto = nomeProduto;
		this.preco = preco;
		this.contentType = contentType;
	}

	@Column(name = "NOME_PRODUTO", length = 100, nullable = false) 
	public String getnomeProduto() {
		return nomeProduto;
	}

	public void setUnomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

    @Column(name = "PRECO", length = 100, nullable = false) 
	public Float getpreco() {
		return preco;
	}

	public void setpreco(Float preco) {
		this.preco = preco;
	}

 

    @Column(length = 50, nullable = true) 
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

   

	@Override
	public String toString() {
		return "Produto [id=" + this.getId() + ", Nome do produto=" + nomeProduto + ", Preço=" + preco;
	}


	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	

}
