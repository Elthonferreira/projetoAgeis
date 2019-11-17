package com.example.saude.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.saude.models.Sintoma;

@Repository
public interface SintomaRepository extends JpaRepository<Sintoma, String>{
	public Sintoma findById(Long id);
}
