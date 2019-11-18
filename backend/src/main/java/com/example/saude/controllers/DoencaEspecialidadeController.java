package com.example.saude.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.saude.models.DoencaEspecialidade;
import com.example.saude.services.DoencaEspecialidadeService;

@CrossOrigin("*") // Depois trocar o * pelo endereço do frontend
@RestController
@RequestMapping("/api/doencaespecialidade")
public class DoencaEspecialidadeController {
	
	@Autowired
    private DoencaEspecialidadeService doencaEspecialidadeService;

    @GetMapping("/{doencaId}")
    public ResponseEntity<?> getClinicaEspecialidade(@PathVariable("doencaId") Long doencaId) {
        List<DoencaEspecialidade> doencaEspecialidades = doencaEspecialidadeService.getAll();
        List<DoencaEspecialidade> selectDoencaEspecialidades = new ArrayList<>();
        
        if(doencaEspecialidades.isEmpty()) {
            return new ResponseEntity<>("Nenhuma clinica encontrada.", HttpStatus.NOT_FOUND);
        } else {
            for (DoencaEspecialidade doencaEspecialidade: doencaEspecialidades) {
            	if (doencaEspecialidade.getDoenca_id() == doencaId) {
            		selectDoencaEspecialidades.add(doencaEspecialidade);
            	}
            }
        }
        
        return new ResponseEntity<>(selectDoencaEspecialidades, HttpStatus.OK);
    }
    
//    @PostMapping
//    public ResponseEntity<?> save(@RequestBody SubArea subArea) {
//    	return new ResponseEntity<>(subAreaService.save(subArea).getId_sub_area(), HttpStatus.OK);
//    }
    
}
