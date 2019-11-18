package com.example.saude.repositories;

import com.example.saude.models.Especialidade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadeRepository extends JpaRepository<Especialidade, String> {
    public Especialidade findById(Long Id);
}