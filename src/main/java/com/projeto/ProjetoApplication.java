package com.projeto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projeto.models.model.Cliente;
import com.projeto.models.repository.ClienteRepository;


@SpringBootApplication
public class ProjetoApplication implements ApplicationRunner{
    
	@Autowired
	private ClienteRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Cliente user = new Cliente();
		
		user.setAtivo(true);
		user.setEmail("cocao@cocao.com.br");
		user.setUsername("cocao");
		
		repository.save(user);
		
	}

	

}
