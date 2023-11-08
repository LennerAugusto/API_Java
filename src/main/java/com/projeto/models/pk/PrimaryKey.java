package com.projeto.models.pk;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class PrimaryKey implements Serializable  {

	
	private static final long serialVersionUID = 8633798685519246501L;

	
	private Long id;
	private Long ClienteID;
	private Long ProdutoID;

	/*CRIAÇÃO DO ID DO CLIENTE*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ClienteID")
	public Long getCategoriaID() {
		return ClienteID;
		
	}

	public void setCategoriaID(Long clienteID) {
		ClienteID = clienteID;
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ClienteID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrimaryKey other = (PrimaryKey) obj;
		return Objects.equals(ClienteID, other.ClienteID);
	}
	
	
	/*CRIAÇÃO DO ID DO PRODUTO*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProdutoID")
	public Long getprodutoId() {
		return ProdutoID;
		
	}

	public void setprodutoId(Long produtoId) {
		ProdutoID = produtoId;
		
	}
	
	
}
