package br.com.joaogabriel.drugstore.mapper;

import br.com.joaogabriel.drugstore.entity.User;
import br.com.joaogabriel.drugstore.payload.request.UserRequest;
import br.com.joaogabriel.drugstore.payload.response.UserViewResponse;

public class UserMapper  {

	public UserViewResponse toUserViewResponse(User user) {
		return new UserViewResponse(user.getId(), user.getPerson().getFirstName(), 
				user.getUsername(), user.getEmail(), user.getPerson().getIndividualCertificate(), 
				user.getPerson().getBirthDate(), user.getPerson().getContact().getCellphone());
	}
	
	public User toUser(UserRequest user) {
		return new User(user.username(), user.email(), user.role(), user.hashPassword(), true, user.person(), user.informations());
	}

}
