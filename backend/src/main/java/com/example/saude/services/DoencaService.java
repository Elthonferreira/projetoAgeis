package com.example.saude.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.saude.models.Doenca;
import com.example.saude.repositories.DoencaRepository;

@Service
public class DoencaService {
	
	 @Autowired
	 private DoencaRepository doencaRepository;

	 public Doenca save(Doenca doenca) {
	    return doencaRepository.save(doenca);
	 }

	 public List<Doenca> getAll() {
	     return doencaRepository.findAll();
	 }
	 
	 public Doenca getById(Long id) {
		 return doencaRepository.findById(id);
	 }
	 
	 public Doenca update(Doenca doenca) {
	     return doencaRepository.save(doenca);
	 }

	 public void delete(Doenca doenca) {
		 doencaRepository.delete(doenca);
	 }
}
