package com.projeto.web.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.PropertyValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.projeto.models.service.exception.EmailJaCadastradoException;
import com.projeto.models.service.exception.EntityNotFoundException;
import com.projeto.models.service.exception.HttpMediaTypeNotSupportedException;
import com.projeto.web.response.Fields;
import com.projeto.web.response.MensagemErroSistema;

@RestControllerAdvice
public class SistemaExceptionHandler {

	@Autowired
	private MessageSource messageResource;
	
	@ExceptionHandler(PropertyValueException.class)
	public ResponseEntity<?> propertyValueException(PropertyValueException ex, WebRequest request){
		
		MensagemErroSistema erro = new MensagemErroSistema
				.Builder()
				.addStatus(HttpStatus.BAD_REQUEST.value())
				.addMensagem(ex.getMessage())
				.addDescricao("Informar o conteudo do campo no cadastro")
				.addError(true)
				.addData(new Date())
				.build();
		
		return ResponseEntity.ok().body(erro);
		
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> entityNotFoundException(EntityNotFoundException ex, WebRequest request){
		
		MensagemErroSistema erro = new MensagemErroSistema();
		erro.setStatus(HttpStatus.BAD_REQUEST.value());
		erro.setMensagem(ex.getMessage());
		erro.setData(new Date());
		erro.setError(true);
		erro.setDescricao("Id digitado não encontrado");
		
		return ResponseEntity.ok().body(erro);
		
	}
	
	@ExceptionHandler(EmailJaCadastradoException.class)
	public ResponseEntity<?> emailJaCadastradoException(EmailJaCadastradoException ex, WebRequest request){
		
		MensagemErroSistema erro = new MensagemErroSistema();
		erro.setStatus(HttpStatus.BAD_REQUEST.value());
		erro.setMensagem(ex.getMessage());
		erro.setData(new Date());
		erro.setError(true);
		erro.setDescricao("Email já cadastrado");
		
		return ResponseEntity.ok().body(erro);
		
	}
	
	
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public ResponseEntity<?> httpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException ex, WebRequest request){
		
		MensagemErroSistema erro = new MensagemErroSistema();
		erro.setStatus(HttpStatus.BAD_REQUEST.value());
		erro.setMensagem(ex.getMessage());
		erro.setData(new Date());
		erro.setError(true);
		erro.setDescricao("(Media Type)Tipo de dado informado não é suportado");
		
		return ResponseEntity.ok().body(erro);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request){
		
		BindingResult bindingResult = ex.getBindingResult();
		List<Fields> fields = new ArrayList<>();
		for (FieldError fieldError : bindingResult.getFieldErrors()) {
			String message = messageResource.getMessage(fieldError, LocaleContextHolder.getLocale());
			Fields f = new Fields();
			f.setMensagemCliente(message);
			f.setNome(fieldError.getField());
			fields.add(f);
		}
		/*List<Fields> fields = bindingResult.getFieldErrors()
										.stream()
										.map( fieldError -> {
											String mensagem = messageResource.getMessage(fieldError, LocaleContextHolder.getLocale());
											Fields field = new Fields();
											field.setNome(fieldError.getField());
											field.setMensagemCliente("");
											
										})
										.collect(Collectors.toList());
		*/
		MensagemErroSistema erro = MensagemErroSistema
				.builder()
				.addStatus(HttpStatus.BAD_REQUEST.value())
				.addMensagem("Informar o conteudo do campo no cadastro")
				.addDescricao("Informar o conteudo do campo no cadastro")
				.addError(true)
				.addFields(fields)
				.addData(new Date())
				.build();
		
		
		return ResponseEntity.ok().body(erro);
		
	}
	
}
