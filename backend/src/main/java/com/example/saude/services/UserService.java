package com.example.saude.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.saude.models.Usuario;
import com.example.saude.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepository;

    public Usuario save(Usuario user) {
        return userRepository.save(user);
    }

    public List<Usuario> getAll() {
        return userRepository.findAll();
    }

    public Usuario getByEmail(String email) {
    	return userRepository.findByEmail(email);
    }
    
    public Usuario getById(Long id) {
    	return userRepository.findById(id);
    }

    public Usuario update(Usuario user) {
        return userRepository.save(user);
    }

    public void delete(Usuario user) {
        userRepository.delete(user);
    }
}
