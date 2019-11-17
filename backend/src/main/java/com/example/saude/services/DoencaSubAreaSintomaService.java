package com.example.saude.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.saude.models.DoencaSubAreaSintoma;
import com.example.saude.repositories.DoencaSubAreaSintomaRepository;

@Service
public class DoencaSubAreaSintomaService {
	
	 @Autowired
	 private DoencaSubAreaSintomaRepository doencaSubAreaSintomaRepository;

	 public DoencaSubAreaSintoma save(DoencaSubAreaSintoma doencaSubAreaSintoma) {
	    return doencaSubAreaSintomaRepository.save(doencaSubAreaSintoma);
	 }

	 public List<DoencaSubAreaSintoma> getAll() {
	     return doencaSubAreaSintomaRepository.findAll();
	 }
	    
	 public DoencaSubAreaSintoma update(DoencaSubAreaSintoma doencaSubAreaSintoma) {
	     return doencaSubAreaSintomaRepository.save(doencaSubAreaSintoma);
	 }

	 public void delete(DoencaSubAreaSintoma doencaSubAreaSintoma) {
		 doencaSubAreaSintomaRepository.delete(doencaSubAreaSintoma);
	 }
}
