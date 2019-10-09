package com.example.saude.services;

import com.example.saude.models.Clinica;
import com.example.saude.repositories.ClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicaService {
    @Autowired
    private ClinicaRepository clinicaRepository;

    public Clinica save(Clinica clinica) {
        return clinicaRepository.save(clinica);
    }

    public List<Clinica> getAll() {
        return clinicaRepository.findAll();
    }

    public Clinica getByNome(String nome) {return clinicaRepository.findByNome(nome);}

    public Clinica update(Clinica clinica) {
        return clinicaRepository.save(clinica);
    }

    public void delete(Clinica clinica) {
        clinicaRepository.delete(clinica);
    }
}
