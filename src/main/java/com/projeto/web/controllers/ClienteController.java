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
import com.projeto.models.service.ClienteService;
import com.projeto.web.response.MensagemSistema;
import com.projeto.web.swagger.ClienteRestControllerApi;

@RestController
@RequestMapping(value="/rest/cliente")
public class ClienteController implements ClienteRestControllerApi{
	
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private MensagemSistema<ClienteResponse> mensagem;
	
	@Override
	@GetMapping(value ="/listar",
	produces = { MediaType.APPLICATION_JSON_VALUE, 
			 MediaType.APPLICATION_XML_VALUE })
	public List<ClienteResponse> list(){
		return clienteService.list();
	}



	@Override
	@PutMapping(value="/buscar/{id}",
			produces = { MediaType.APPLICATION_JSON_VALUE, 
					 MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> buscarClientePorId(@PathVariable("id") Long id) {
		var clienteResponse = clienteService.read(id);
		mensagem.showMensagem("Usuario encontrado com sucesso!", HttpStatus.OK.value(), clienteResponse);
		return ResponseEntity.ok().body(mensagem);
	}

	@Override
	@PostMapping(value="/salvar",
		consumes = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE },
		produces = { MediaType.APPLICATION_JSON_VALUE, 
				MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> salvarCliente(@RequestBody ClienteRequest cliente) {
		
		var clienteResponse = clienteService.save(cliente);
		mensagem.showMensagem("Cliente salvo com sucesso!", HttpStatus.OK.value(), clienteResponse);
		return ResponseEntity.ok().body(mensagem);
				
	}

	@Override
	@PutMapping(value="/alterar/{id}",
			consumes = { MediaType.APPLICATION_JSON_VALUE,
					 MediaType.APPLICATION_XML_VALUE },
			produces = { MediaType.APPLICATION_JSON_VALUE, 
					 MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> alterarCliente(@PathVariable("id") Long id, @RequestBody ClienteRequest cliente) {	
		var clienteResponse = clienteService.update(id, cliente);
		mensagem.showMensagem("Cliente alterado com sucesso!", HttpStatus.OK.value(), clienteResponse);
		return ResponseEntity.ok().body(mensagem);
	}

	@Override
	@DeleteMapping(value="/excluir/{id}",
			consumes = { MediaType.APPLICATION_JSON_VALUE,
					 MediaType.APPLICATION_XML_VALUE },
			produces = { MediaType.APPLICATION_JSON_VALUE, 
					 MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> excluirCliente(Long id) {
		clienteService.delete(id);
		mensagem.showMensagem("Cliente excluido com sucesso!", HttpStatus.OK.value(), null);
		return ResponseEntity.ok().body(mensagem);
	}



	@Override
	public Page<ClienteResponse> listaPaginada(Integer page, Integer pageSize, String dir, String props) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Page<ClienteResponse> listaPagiadaPornome(Integer page, Integer pageSize, String dir, String props) {
		// TODO Auto-generated method stub
		return null;
	}
	
}