package com.projeto.models.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.models.data.ClienteRequest;
import com.projeto.models.data.ClienteResponse;
import com.projeto.models.model.Cliente;
import com.projeto.models.repository.ClienteRepository;
import com.projeto.models.service.ClienteService;
import com.projeto.models.service.exception.EmailJaCadastradoException;
import com.projeto.models.service.mapper.ConverterEntity;
import com.projeto.models.service.pagination.pageRequestConfig;

import jakarta.persistence.EntityNotFoundException;


@Service 
@Transactional 
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ConverterEntity converter;
	
	@Override
	public ClienteResponse save(ClienteRequest entity) {
		
		var cliente = converter.parseObject(entity, Cliente.class);
		var clienteCadastrado = clienteRepository.finddClienteByEmail(cliente.getEmail());
		if(cliente.isPresent() && clienteCadastrado.get().equals(cliente)) {
			throw new EmailJaCadastradoException("O email informado já esta cadastrado");
		}
		
		
		cliente = clienteoRepository.save(cliente);
		var clienteResponse = converter.parseObject(cliente, clienteResponse.class);
		return clienteResponse;
	}

	@Override
	public ClienteResponse update(Long id, ClienteRequest entity) {
		var cliente = converter.parseObject(entity, Cliente.class);
		
		var clienteCadastrado = clienteRepository.findById(id)
				.orElseThrow(()->  new EntityNotFoundException("Entidade nao encontrada"));;
	
		clienteoCadastrado.setEmail(cliente.getEmail());
		clienteCadastrado.setUsername(cliente.getUsername());
		
		clienteRepository.save(clienteCadastrado);
		var clienteResponse = converter.parseObject(clienteCadastrado, ClienteResponse.class);
		return clienteResponse;
	}

	@Override
	public void delete(Long id) {
		clienteRepository.deleteById(id);

	}

	@Override
	@Transactional(readOnly = true)
	public ClienteResponse read(Long id) {
		
		var usuario = usuarioRepository.findById(id)
		.orElseThrow(()->  new EntityNotFoundException("Entidade nao encontrada"));
		
		return converter.parseObject(usuario, ClienteResponse.class);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ClienteResponse> list() {
		
		
		return converter.parseListObjects(clienteRepository.findAll(), ClienteResponse.class);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ClienteResponse> list(String key) {
		
		return converter.parseListObjects(ClienteRepository.findByUseNname(key),ClienteResponse.class);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<ClienteResponse> listPagination(Integer page, Integer pageSize, String dir, String props) {
		
		Pageable pagina = pageRequestConfig.gerarPagina(page,pageSize,dir,props);
		
		Page<Cliente> listaCliente = clienteRepository.findAllPagination(pagina);
		
		var listaClienteResponse = converter.parseListObjects(listaCliente.getContent(), ClienteResponse.class);
		
		Page<ClienteResponse> paginaClienteResponse = new PageImpl<>(listaClienteResponse, 
																	   listaCliente.getPageable(),
																	   listaCliente.getTotalElements());
		return paginaClienteResponse;
	}

	@Override
	public ClienteResponse save(ClienteResponse entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClienteResponse update(ClienteRequest id, ClienteResponse entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(ClienteRequest id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClienteResponse read(ClienteRequest id) {
		// TODO Auto-generated method stub
		return null;
	}

}
