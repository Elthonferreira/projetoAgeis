package com.example.saude.controllers;

import com.example.saude.models.Especialidade;
import com.example.saude.services.EspecialidadeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*") // Depois trocar o * pelo endereço do frontend
@RestController
@RequestMapping("/api/especialidade")
public class EspecialidadeController {
    @Autowired
    private EspecialidadeService especialidadeService;
    
    @GetMapping("/{especialidadeId}")
    public ResponseEntity<?> getById(@PathVariable("especialidadeId") Long especialidadeId) {
        Especialidade especialidade = especialidadeService.getById(especialidadeId);
        
        if(especialidade == null) {
            return new ResponseEntity<>("Especialidade com id "+especialidadeId+" não existe", HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(especialidade, HttpStatus.OK);
        }
    }
//
//    @PostMapping
//    public ResponseEntity<?> save(@RequestBody Clinica clinica) {
//        Clinica aux = especialidadeService.getByNome(clinica.getNome());
//        if(aux == null) {
//            return new ResponseEntity<>(especialidadeService.save(clinica),HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<>("Clínica com nome "+clinica.getNome()+" já existe", HttpStatus.BAD_REQUEST);
//        }
//    }
}

