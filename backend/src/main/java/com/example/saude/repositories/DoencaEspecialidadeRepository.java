package com.example.saude.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.saude.models.DoencaEspecialidade;

@Repository
public interface DoencaEspecialidadeRepository extends JpaRepository<DoencaEspecialidade, String>{
	public DoencaEspecialidade findById(Long id);
}
