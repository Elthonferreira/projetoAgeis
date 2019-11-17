package com.example.saude.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.saude.models.UserSubAreaSintoma;
import com.example.saude.repositories.UserSubAreaSintomaRepository;

@Service
public class UserSubAreaSintomaService {
	
	 @Autowired
	 private UserSubAreaSintomaRepository userSubAreaSintomaRepository;

	 public UserSubAreaSintoma save(UserSubAreaSintoma userSubAreaSintoma) {
	    return userSubAreaSintomaRepository.save(userSubAreaSintoma);
	 }

	 public List<UserSubAreaSintoma> getAll() {
	     return userSubAreaSintomaRepository.findAll();
	 }
	    
	 public UserSubAreaSintoma update(UserSubAreaSintoma userSubAreaSintoma) {
	     return userSubAreaSintomaRepository.save(userSubAreaSintoma);
	 }

	 public void delete(UserSubAreaSintoma userSubAreaSintoma) {
		 userSubAreaSintomaRepository.delete(userSubAreaSintoma);
	 }
}
