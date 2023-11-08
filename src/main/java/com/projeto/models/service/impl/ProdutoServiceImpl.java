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
import com.projeto.models.data.ProdutoRequest;
import com.projeto.models.data.ProdutoResponse;
import com.projeto.models.model.Cliente;
import com.projeto.models.model.Produto;
import com.projeto.models.repository.ClienteRepository;
import com.projeto.models.repository.ProdutoRepository;
import com.projeto.models.service.ProdutoService;
import com.projeto.models.service.exception.EmailJaCadastradoException;
import com.projeto.models.service.exception.ProdutoJaCadastradoException;
import com.projeto.models.service.mapper.ConverterEntity;
import com.projeto.models.service.pagination.pageRequestConfig;

import jakarta.persistence.EntityNotFoundException;



@Service 
@Transactional
public class ProdutoServiceImpl implements ProdutoService{
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private ConverterEntity converter;
	
	@Override
	public ProdutoResponse save(ProdutoRequest entity) {
		
		var produto = converter.parseObject(entity, Produto.class);
		var produtoCadastrado = produtoRepository.finddProdutoByEmail(produto.getEmail());
		if(produto.isPresent() && produtoCadastrado.get().equals(produto)) {
			throw new ProdutoJaCadastradoException("O produto informado já esta cadastrado");
		}
		
		
		produto = produtoRepository.save(produto);
		var produtoResponse = converter.parseObject(produto, ProdutoResponse.class);
		return produtoResponse;
	}

	@Override
	public ProdutoResponse update(Long produtoId, ProdutoRequest entity) {
		var produto = converter.parseObject(entity, Produto.class);
		
		var produtoCadastrado = produtoRepository.findById(produtoId)
				.orElseThrow(()->  new EntityNotFoundException("Entidade nao encontrada"));;
	
		produtoCadastrado.setEmail(produto.getEmail());
		produtoCadastrado.setUsername(produto.getUsername());
		
		produtoRepository.save(produtoCadastrado);
		var produtoResponse = converter.parseObject(produtoCadastrado, ProdutoResponse.class);
		return produtoResponse;
	}

	@Override
	public void delete(Long produtoId) {
		ProdutoRepository.deleteById(produtoId);

	}

	@Override
	@Transactional(readOnly = true)
	public ProdutoResponse read(Long produtoId) {
		
		var produto = produtoRepository.findById(produtoId)
		.orElseThrow(()->  new EntityNotFoundException("Entidade nao encontrada"));
		
		return converter.parseObject(produto, ProdutoResponse.class);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProdutoResponse> list() {
		
		
		return converter.parseListObjects(produtoRepository.findAll(), ProdutoResponse.class);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProdutoResponse> list(String key) {
		
		return converter.parseListObjects(ProdutoRepository.findByNomeProduto(key),ProdutoResponse.class);
	}



	@Override
	public ProdutoResponse save(ProdutoResponse entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProdutoResponse update(ProdutoRequest produtoId, ProdutoResponse entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(ProdutoRequest produtoId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProdutoResponse read(ClienteRequest produtoId) {
		// TODO Auto-generated method stub
		return null;
	}
}
