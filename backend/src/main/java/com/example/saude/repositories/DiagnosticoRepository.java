package com.example.saude.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.saude.models.Diagnostico;

@Repository
public interface DiagnosticoRepository extends JpaRepository<Diagnostico, String>{
	
}
