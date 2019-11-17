package com.example.saude.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.saude.models.SubArea;
import com.example.saude.repositories.SubAreaRepository;

@Service
public class SubAreaService {
	
	 @Autowired
	 private SubAreaRepository subAreaRepository;

	 public SubArea save(SubArea subArea) {
	    return subAreaRepository.save(subArea);
	 }

	 public List<SubArea> getAll() {
	     return subAreaRepository.findAll();
	 }
	 
	 public SubArea getById(Long id) {
	    return subAreaRepository.findById(id);
	 }
	    
	 public SubArea update(SubArea subArea) {
	     return subAreaRepository.save(subArea);
	 }

	 public void delete(SubArea subArea) {
		 subAreaRepository.delete(subArea);
	 }
}
