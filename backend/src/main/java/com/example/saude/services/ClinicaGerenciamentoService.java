package com.example.saude.services;

import com.example.saude.models.Clinica;
import com.example.saude.models.ClinicaGerenciamento;
import com.example.saude.repositories.ClinicaGerenciamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClinicaGerenciamentoService {

    @Autowired
    private ClinicaGerenciamentoRepository clinicaGerenciamentoRepository;

    public ClinicaGerenciamento save(ClinicaGerenciamento clinica) {return clinicaGerenciamentoRepository.save(clinica);}

    public List<ClinicaGerenciamento> getAll() {return clinicaGerenciamentoRepository.findAll();}

    public ClinicaGerenciamento getById(Long id) {return clinicaGerenciamentoRepository.findById(id);}

    public ClinicaGerenciamento update(ClinicaGerenciamento clinica) {return clinicaGerenciamentoRepository.save(clinica);}

    public void delete(ClinicaGerenciamento clinica) {
        clinicaGerenciamentoRepository.delete(clinica);
    }

}
