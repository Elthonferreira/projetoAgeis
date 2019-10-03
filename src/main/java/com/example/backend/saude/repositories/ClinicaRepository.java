package com.example.backend.saude.repositories;

import com.example.backend.saude.models.Clinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicaRepository extends JpaRepository<Clinica, String> {
    public Clinica findByNome(String nome);
}