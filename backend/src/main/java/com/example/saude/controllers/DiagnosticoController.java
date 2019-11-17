package com.example.saude.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.saude.models.Diagnostico;
import com.example.saude.services.DiagnosticoService;
@CrossOrigin("*") // Depois trocar o * pelo endereço do frontend
@RestController
@RequestMapping("/api/diagnostico")
public class DiagnosticoController {
	
	@Autowired
    private DiagnosticoService diagnosticoService;

//    @GetMapping("/{diagnosticoId}")
//    public ResponseEntity<?> getByCpf(@PathVariable("diagnosticoId") Long diagnosticoId) {
//        Diagnostico diagnostico = diagnosticoService.getById(sintomaId);
//        if(sintoma == null) {
//            return new ResponseEntity<>("Sintoma com id " + sintomaId + " não existe", HttpStatus.NOT_FOUND);
//        }
//        else {
//            return new ResponseEntity<>(sintoma, HttpStatus.OK);
//        }
//    }
    
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Diagnostico diagnostico) {
    	return new ResponseEntity<>(diagnosticoService.save(diagnostico).getId_diagnostico(), HttpStatus.OK);
    }
    
}
