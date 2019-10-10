package com.example.saude.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.saude.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	public User findById(Long id);
}
