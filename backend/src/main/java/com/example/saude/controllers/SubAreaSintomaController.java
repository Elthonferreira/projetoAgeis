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

import com.example.saude.models.Sintoma;
import com.example.saude.models.SubAreaSintoma;
import com.example.saude.services.SintomaService;
import com.example.saude.services.SubAreaSintomaService;

@CrossOrigin("*") // Depois trocar o * pelo endereço do frontend
@RestController
@RequestMapping("/api/subareasintoma")
public class SubAreaSintomaController {
	
	@Autowired
    private SubAreaSintomaService subAreaSintomaService;
	@Autowired
	private SintomaService sintomaService;

    @GetMapping("/{subAreaId}")
    public ResponseEntity<?> getByUserID(@PathVariable("subAreaId") Long subAreaId) {
        List<SubAreaSintoma> subAreaSintomas = subAreaSintomaService.getAll();
        List<Sintoma> selectSubAreaSintomas = new ArrayList<>();
        
        if(subAreaSintomas.isEmpty()) {
            return new ResponseEntity<>("Nenhuma sintoma cadastrado.", HttpStatus.NOT_FOUND);
        } else {
            for (SubAreaSintoma subAreaSintoma: subAreaSintomas) {
            	if (subAreaSintoma.getSub_area_id() == subAreaId) {
            		selectSubAreaSintomas.add(sintomaService.getById(subAreaSintoma.getSintoma_id()));
            	}
            }
        }
        
        return new ResponseEntity<>(selectSubAreaSintomas, HttpStatus.OK);
    }
    
    @GetMapping("/{subAreaId}/{sintomaId}")
    public ResponseEntity<?> getByUserID(@PathVariable("subAreaId") Long subAreaId, @PathVariable("sintomaId") Long sintomaId) {
        List<SubAreaSintoma> subAreaSintomas = subAreaSintomaService.getAll();
        
        if(subAreaSintomas.isEmpty()) {
            return new ResponseEntity<>("Nenhuma sub area - sintoma cadastrado.", HttpStatus.NOT_FOUND);
        } else {
            for (SubAreaSintoma subAreaSintoma: subAreaSintomas) {
            	if (subAreaSintoma.getSub_area_id() == subAreaId && subAreaSintoma.getSintoma_id() == sintomaId) {
            		return new ResponseEntity<>(subAreaSintoma.getId_sub_area_sintoma(), HttpStatus.OK);
            	}
            }
        }
        
        return new ResponseEntity<>(-1, HttpStatus.OK);
    }

//    @PostMapping
//    public ResponseEntity<?> save(@RequestBody SubArea subArea) {
//    	return new ResponseEntity<>(subAreaSintomaService.save(subArea).getId_sub_area(), HttpStatus.OK);
//    }
    
}
