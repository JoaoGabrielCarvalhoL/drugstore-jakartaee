package br.com.joaogabriel.drugstore.payload.response;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public record UserViewResponse(
		UUID id, 
		String firstName, 
		String username, 
		String email, 
		String individualCertificate,
		LocalDate birhtDate, 
		String cellphone) implements Serializable {

}
