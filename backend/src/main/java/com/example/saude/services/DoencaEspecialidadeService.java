package com.example.saude.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.saude.models.DoencaEspecialidade;
import com.example.saude.repositories.DoencaEspecialidadeRepository;

@Service
public class DoencaEspecialidadeService {
	
	 @Autowired
	 private DoencaEspecialidadeRepository doencaEspecialidadeRepository;

	 public DoencaEspecialidade save(DoencaEspecialidade doencaEspecialidade) {
	    return doencaEspecialidadeRepository.save(doencaEspecialidade);
	 }

	 public List<DoencaEspecialidade> getAll() {
	     return doencaEspecialidadeRepository.findAll();
	 }
	 
	 public DoencaEspecialidade update(DoencaEspecialidade doencaEspecialidade) {
	     return doencaEspecialidadeRepository.save(doencaEspecialidade);
	 }

	 public void delete(DoencaEspecialidade doencaEspecialidade) {
		 doencaEspecialidadeRepository.delete(doencaEspecialidade);
	 }
}
