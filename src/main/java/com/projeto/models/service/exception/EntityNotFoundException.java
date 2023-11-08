package com.projeto.models.service.exception;

public class EntityNotFoundException extends NegocioException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8879547830661462055L;

	public EntityNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public EntityNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
}
