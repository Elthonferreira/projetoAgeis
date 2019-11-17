package com.example.saude.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.saude.models.Sintoma;
import com.example.saude.repositories.SintomaRepository;

@Service
public class SintomaService {
	
	 @Autowired
	 private SintomaRepository sintomaRepository;

	 public Sintoma save(Sintoma sintoma) {
	    return sintomaRepository.save(sintoma);
	 }

	 public List<Sintoma> getAll() {
	     return sintomaRepository.findAll();
	 }
	    
	 public Sintoma getById(Long id) {
		 return sintomaRepository.findById(id);
	 }
	 
	 public Sintoma update(Sintoma sintoma) {
	     return sintomaRepository.save(sintoma);
	 }

	 public void delete(Sintoma sintoma) {
		 sintomaRepository.delete(sintoma);
	 }
}
