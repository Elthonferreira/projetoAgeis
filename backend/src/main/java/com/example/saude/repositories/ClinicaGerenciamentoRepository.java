package com.example.saude.repositories;

import com.example.saude.models.ClinicaGerenciamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicaGerenciamentoRepository extends JpaRepository<ClinicaGerenciamento, String>{
    public ClinicaGerenciamento findById(Long id);
}

