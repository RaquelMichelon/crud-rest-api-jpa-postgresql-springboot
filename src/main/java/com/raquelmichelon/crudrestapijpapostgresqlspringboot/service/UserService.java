package com.raquelmichelon.crudrestapijpapostgresqlspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raquelmichelon.crudrestapijpapostgresqlspringboot.repository.UserRepository;
import com.raquelmichelon.crudrestapijpapostgresqlspringboot.model.User;

//@Service annotation is used to mark the class as a service provider that provide some business functionalities.
@Service
public class UserService {

	//@Autowired is used to inject UserRepository bean to local variable.
	@Autowired
	private UserRepository userRepository;

	public Object createUser(User reqData) {
		return userRepository.save(reqData);
	}

	public Object getAllUsers() {
		return userRepository.findAll();
	}

	public User isDataExist(User reqData) {
		return userRepository.findByEmailAndMobNo(reqData.getEmail(), reqData.getMobNo());
	}

	public Object getUserById(Long id) {
		return userRepository.findById(id);
	}

	public Object updateUser(User reqData, User isData) {
		isData.setName(reqData.getName());
		isData.setEmail(reqData.getEmail());
		isData.setMobNo(reqData.getMobNo());
		isData.setPassword(reqData.getPassword());
		return userRepository.save(isData);
	}

	public Object deleteUserById(Long id) {
		userRepository.deleteById(id);
		return null;
	}
}
