package com.example.saude.controllers;

import com.example.saude.models.Clinica;
import com.example.saude.services.ClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*") // Depois trocar o * pelo endereço do frontend
@RestController
@RequestMapping("/clinicas")
public class ClinicaController {
    @Autowired
    private ClinicaService clinicaService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Clinica> clinicas = clinicaService.getAll();
        if(clinicas.isEmpty()) {
            return new ResponseEntity<>("Sem clínicas cadastradas", HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(clinicas, HttpStatus.OK);
        }
    }

    @GetMapping("/{nome}")
    public ResponseEntity<?> getByCpf(@PathVariable("nome") String nome) {
        Clinica clinica = clinicaService.getByNome(nome);
        if(clinica == null) {
            return new ResponseEntity<>("Clínica com nome "+nome+" não existe", HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(clinica, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Clinica clinica) {
        Clinica aux = clinicaService.getByNome(clinica.getNome());
        if(aux == null) {
            return new ResponseEntity<>(clinicaService.save(clinica),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Clínica com nome "+clinica.getNome()+" já existe", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Clinica novo) {
        Clinica velho = clinicaService.getByNome(novo.getNome());
        if(velho == null) {
            return new ResponseEntity<>("Clínica com nome "+novo.getNome()+" não existe", HttpStatus.NOT_FOUND);
        }
        else {
            novo.setId_clinica(velho.getId_clinica());
            return new ResponseEntity<>(clinicaService.update(novo),HttpStatus.OK);
        }
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody Clinica clinica) {
        Clinica aux = clinicaService.getByNome(clinica.getNome());
        if(aux == null) {
            return new ResponseEntity<>("Clínica com nome "+clinica.getNome()+" não existe", HttpStatus.NOT_FOUND);
        }
        else {
            clinicaService.delete(aux);
            return new ResponseEntity<>("Clínica com nome "+clinica.getNome()+" foi deletado", HttpStatus.OK);
        }
    }
}

