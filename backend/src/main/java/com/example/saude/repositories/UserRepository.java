package com.example.saude.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.saude.models.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, String> {
	public Usuario findByEmail(String email);
	public Usuario findById(Long id);
}
