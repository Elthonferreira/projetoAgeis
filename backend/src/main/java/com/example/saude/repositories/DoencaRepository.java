package com.example.saude.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.saude.models.Doenca;

@Repository
public interface DoencaRepository extends JpaRepository<Doenca, String>{
	public Doenca findById(Long id);
}
