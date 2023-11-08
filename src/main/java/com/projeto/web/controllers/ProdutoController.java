package com.projeto.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.models.data.ClienteRequest;
import com.projeto.models.data.ClienteResponse;
import com.projeto.models.data.ProdutoRequest;
import com.projeto.models.data.ProdutoResponse;
import com.projeto.models.service.ClienteService;
import com.projeto.models.service.ProdutoService;
import com.projeto.web.response.MensagemSistema;
import com.projeto.web.swagger.ClienteRestControllerApi;
import com.projeto.web.swagger.ProdutoRestControllerApi;

@RestController
@RequestMapping(value="/rest/produto")
public class ProdutoController implements ProdutoRestControllerApi{
	
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private MensagemSistema<ProdutoResponse> mensagem;
	
	@Override
	@GetMapping(value ="/listar",
	produces = { MediaType.APPLICATION_JSON_VALUE, 
			 MediaType.APPLICATION_XML_VALUE })
	public List<ProdutoResponse> list(){
		return produtoService.list();
	}



	@Override
	@PutMapping(value="/buscar/{id}",
			produces = { MediaType.APPLICATION_JSON_VALUE, 
					 MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> buscarProdutoPorId(@PathVariable("id") Long produtoId) {
		var produtoResponse = produtoService.read(produtoId);
		mensagem.showMensagem("Produto encontrado com sucesso!", HttpStatus.OK.value(), produtoResponse);
		return ResponseEntity.ok().body(mensagem);
	}

	@Override
	@PostMapping(value="/salvar",
		consumes = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE },
		produces = { MediaType.APPLICATION_JSON_VALUE, 
				MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> salvarProduto(@RequestBody ProdutoRequest produto) {
		
		var produtoResponse = produtoService.save(produto);
		mensagem.showMensagem("Produto salvo com sucesso!", HttpStatus.OK.value(), produtoResponse);
		return ResponseEntity.ok().body(mensagem);
				
	}

	@Override
	@PutMapping(value="/alterar/{id}",
			consumes = { MediaType.APPLICATION_JSON_VALUE,
					 MediaType.APPLICATION_XML_VALUE },
			produces = { MediaType.APPLICATION_JSON_VALUE, 
					 MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> alterarProduto(@PathVariable("id") Long produtoId, @RequestBody ProdutoRequest produto) {	
		var produtoResponse = produtoService.update(produtoId, produto);
		mensagem.showMensagem("Produto alterado com sucesso!", HttpStatus.OK.value(), produtoResponse);
		return ResponseEntity.ok().body(mensagem);
	}

	@Override
	@DeleteMapping(value="/excluir/{id}",
			consumes = { MediaType.APPLICATION_JSON_VALUE,
					 MediaType.APPLICATION_XML_VALUE },
			produces = { MediaType.APPLICATION_JSON_VALUE, 
					 MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> excluirProduto(Long produtoId) {
		produtoService.delete(produtoId);
		mensagem.showMensagem("Produto excluido com sucesso!", HttpStatus.OK.value(), null);
		return ResponseEntity.ok().body(mensagem);
	}



	@Override
	public ResponseEntity<?> salvarCliente(ProdutoRequest produto) {
		// TODO Auto-generated method stub
		return null;
	}


	
}