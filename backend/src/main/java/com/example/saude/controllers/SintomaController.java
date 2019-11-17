package com.example.saude.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.saude.models.Sintoma;
import com.example.saude.services.SintomaService;

@CrossOrigin("*") // Depois trocar o * pelo endereço do frontend
@RestController
@RequestMapping("/api/sintoma")
public class SintomaController {
	
	@Autowired
    private SintomaService sintomaService;

    @GetMapping("/first/{sintomaId}")
    public ResponseEntity<?> getByCpf(@PathVariable("sintomaId") Long sintomaId) {
        Sintoma sintoma = sintomaService.getById(sintomaId);
        if(sintoma == null) {
            return new ResponseEntity<>("Sintoma com id " + sintomaId + " não existe", HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(sintoma, HttpStatus.OK);
        }
    }
    
//    @PostMapping
//    public ResponseEntity<?> save(@RequestBody SubArea subArea) {
//    	return new ResponseEntity<>(subAreaService.save(subArea).getId_sub_area(), HttpStatus.OK);
//    }
    
}
