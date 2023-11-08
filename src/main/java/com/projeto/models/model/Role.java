package com.projeto.models.model;


import com.projeto.models.pk.PrimaryKey;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "TAB_ROLE")

public class Role extends PrimaryKey{
	
	private static final long serialVersionUID = -1462710991778751385L;
	
	public Role() {
		
	}
	public Role(String nome) {
		super();
		this.nome = nome;
	}

	private String nome;
	@Column(name = "nome", length = 50, nullable =false)

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Role [nome=" + nome + "]";
	}
	
	
}