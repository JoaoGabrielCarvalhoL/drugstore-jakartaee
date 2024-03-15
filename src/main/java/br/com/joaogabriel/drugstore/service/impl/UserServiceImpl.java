package br.com.joaogabriel.drugstore.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.joaogabriel.drugstore.entity.User;
import br.com.joaogabriel.drugstore.mapper.UserMapper;
import br.com.joaogabriel.drugstore.payload.response.UserViewResponse;
import br.com.joaogabriel.drugstore.repository.UserRepository;
import br.com.joaogabriel.drugstore.service.UserService;

public class UserServiceImpl implements UserService, Serializable {
	
	private static final long serialVersionUID = 1L;
	private final Logger logger = Logger.getLogger(getClass().getName());
	private final UserRepository userRepository = new UserRepository(User.class);
	private final UserMapper mapper = new UserMapper();
	
	@Override
	public List<UserViewResponse> findAll() {
		logger.log(Level.INFO, "Getting all users");
		return this.userRepository.findAll().stream().map(mapper::toUserViewResponse)
		.toList();
	}

	@Override
	public UserViewResponse save(User user) {
		logger.log(Level.INFO, "Saving {0} into database.", user);
		this.userRepository.save(user);
		return mapper.toUserViewResponse(user);
	}

	@Override
	public UserViewResponse findById(UUID id) {
		logger.log(Level.INFO, "Find user by id: {0}", id);
		return mapper.toUserViewResponse(this.userRepository.findById(id));
	}

	@Override
	public User allInformations(UUID id) {
		logger.log(Level.FINE, "Getting all informations from user: {0}", id);
		return this.userRepository.findById(id);
	}

	@Override
	public void delete(User user) {
		logger.log(Level.WARNING, "Deleting user: {0}", user);
		this.userRepository.delete(user);
	}

	@Override
	public void deleteByI(UUID id) {
		logger.log(Level.WARNING, "Deleting user by id: {0}", id);
		this.userRepository.deleteById(id);
	}

}
