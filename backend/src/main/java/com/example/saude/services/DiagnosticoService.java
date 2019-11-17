package com.example.saude.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.saude.models.Diagnostico;
import com.example.saude.repositories.DiagnosticoRepository;

@Service
public class DiagnosticoService {
	
	 @Autowired
	 private DiagnosticoRepository diagnosticoRepository;

	 public Diagnostico save(Diagnostico diagnostico) {
	    return diagnosticoRepository.save(diagnostico);
	 }

	 public List<Diagnostico> getAll() {
	     return diagnosticoRepository.findAll();
	 }
	 
	 public Diagnostico update(Diagnostico diagnostico) {
	     return diagnosticoRepository.save(diagnostico);
	 }

	 public void delete(Diagnostico diagnostico) {
		 diagnosticoRepository.delete(diagnostico);
	 }
}
