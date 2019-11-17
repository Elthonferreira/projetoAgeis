package com.example.saude.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.saude.models.SubAreaSintoma;
import com.example.saude.repositories.SubAreaSintomaRepository;

@Service
public class SubAreaSintomaService {
	
	 @Autowired
	 private SubAreaSintomaRepository subAreaSintomaRepository;

	 public SubAreaSintoma save(SubAreaSintoma subAreaSintoma) {
	    return subAreaSintomaRepository.save(subAreaSintoma);
	 }

	 public List<SubAreaSintoma> getAll() {
	     return subAreaSintomaRepository.findAll();
	 }
	    
	 public SubAreaSintoma update(SubAreaSintoma subAreaSintoma) {
	     return subAreaSintomaRepository.save(subAreaSintoma);
	 }

	 public void delete(SubAreaSintoma subAreaSintoma) {
		 subAreaSintomaRepository.delete(subAreaSintoma);
	 }
}
