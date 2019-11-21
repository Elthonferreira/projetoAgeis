package com.example.saude.repositories;

import com.example.saude.models.Clinica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicaRepository extends JpaRepository<Clinica, String> {
    public Clinica findByNome(String nome);
    public Clinica findByUsuario(String usuario);
    public Clinica findById(Long Id);
}