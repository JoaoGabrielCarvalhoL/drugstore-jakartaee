package br.com.joaogabriel.drugstore.repository;

import java.util.UUID;

import br.com.joaogabriel.drugstore.dao.impl.SimpleGenericDaoImpl;
import br.com.joaogabriel.drugstore.entity.User;

public class UserRepository extends SimpleGenericDaoImpl<User, UUID>{

	public UserRepository(Class<User> clazz) {
		super(clazz);
	}

}
