package br.com.joaogabriel.drugstore.exception;

public class SimpleGenericPersistenceException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public SimpleGenericPersistenceException(String message) {
		super(message);
	}

}
