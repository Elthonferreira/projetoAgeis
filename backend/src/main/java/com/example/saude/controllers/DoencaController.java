package com.example.saude.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.saude.models.Doenca;
import com.example.saude.services.DoencaService;

import java.util.List;

@CrossOrigin("*") // Depois trocar o * pelo endereço do frontend
@RestController
@RequestMapping("/api/doenca")
public class DoencaController {
	
	@Autowired
    private DoencaService doencaService;

    @GetMapping("/{doencaId}")
    public ResponseEntity<?> getById(@PathVariable("doencaId") Long doencaId) {
        Doenca doenca = doencaService.getById(doencaId);
        if(doenca == null) {
            return new ResponseEntity<>("Doenca com id " + doencaId + " não existe", HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(doenca, HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Doenca> doencas = doencaService.getAll();
        if(doencas.isEmpty()) {
            return new ResponseEntity<>("Sem doenças cadastradas", HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(doencas, HttpStatus.OK);
        }
    }
    
//    @PostMapping
//    public ResponseEntity<?> save(@RequestBody SubArea subArea) {
//    	return new ResponseEntity<>(subAreaService.save(subArea).getId_sub_area(), HttpStatus.OK);
//    }
    
}
