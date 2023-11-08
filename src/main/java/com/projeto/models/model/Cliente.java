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
@Table(name = "TAB_CLIENTE")
public class Cliente extends PrimaryKey implements Serializable{

	private static final long serialVersionUID = -2374616540565822199L;

	private String  username;
	private String  email;
	private String  foto;
	private String  contentType;

	
	private boolean ativo;
	
	public Cliente() {
	}

	
    public Cliente(String username, String email, String foto,
			String contentType, boolean ativo) {
		super();
		this.username = username;
		this.email = email;
		this.foto = foto;
		this.contentType = contentType;
		this.ativo = ativo;
	}

	@Column(name = "USERNAME", length = 100, nullable = false) 
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

    @Column(name = "EMAIL", length = 100, nullable = false) 
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    @Column(name = "ATIVO", length = 1, nullable = false) 
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
  
	@Column(length = 100, nullable = true) 
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
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
		return "Usuario [id=" + this.getId() + ", username=" + username + ", email=" + email + ", ativo=" + ativo + "]";
	}


	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	

}
