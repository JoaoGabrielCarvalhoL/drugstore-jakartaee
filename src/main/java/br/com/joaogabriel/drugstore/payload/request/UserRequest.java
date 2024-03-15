package br.com.joaogabriel.drugstore.payload.request;

import java.io.Serializable;

import br.com.joaogabriel.drugstore.entity.SimplePerson;
import br.com.joaogabriel.drugstore.entity.UserInformations;
import br.com.joaogabriel.drugstore.model.enumerations.RoleType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequest(
		@NotBlank
		String username, 
		@Email
		String email, 
		@NotNull
		RoleType role, 
		String hashPassword, 
		SimplePerson person,
		UserInformations informations) implements Serializable {
		
}


