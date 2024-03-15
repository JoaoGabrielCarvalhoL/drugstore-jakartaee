package br.com.joaogabriel.drugstore.service;

import java.util.List;
import java.util.UUID;

import br.com.joaogabriel.drugstore.entity.User;
import br.com.joaogabriel.drugstore.payload.response.UserViewResponse;

public interface UserService {
	
	List<UserViewResponse> findAll();
	
	UserViewResponse save(User user);
	
	UserViewResponse findById(UUID id);
	
	User allInformations(UUID id);
	
	void delete(User user);
	
	void deleteByI(UUID id);
	

}
