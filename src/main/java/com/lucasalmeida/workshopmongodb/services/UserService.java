package com.lucasalmeida.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasalmeida.workshopmongodb.domain.User;
import com.lucasalmeida.workshopmongodb.dto.UserDto;
import com.lucasalmeida.workshopmongodb.repository.UserRepository;
import com.lucasalmeida.workshopmongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public User fromDto(UserDto objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
