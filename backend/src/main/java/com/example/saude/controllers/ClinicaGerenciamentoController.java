package com.example.saude.controllers;

import com.example.saude.models.Clinica;
import com.example.saude.models.ClinicaGerenciamento;
import com.example.saude.models.Usuario;
import com.example.saude.services.ClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*") // Depois trocar o * pelo endereço do frontend
@RestController
@RequestMapping("/api/clinicaGerenciamento")
public class ClinicaGerenciamentoController {

    @Autowired
    private ClinicaService clinicaService;

  /*  @GetMapping("/{usuarioId}")
    public List<Usuario> getUsuariosByClinica (Long id_clinica){
        Clinica clinica = new Clinica(id_clinica);
        System.out.println(clinica.getNome());
        return null;
    }*/

    @GetMapping("/{clinicaId}")
    public ResponseEntity<?> getById(@PathVariable("clinicaId") Long clinica_id) {
        Clinica clinica = clinicaService.getById(clinica_id);
        System.out.println(clinica.getNome());
        if(clinica == null) {
            return new ResponseEntity<>("Doenca com id " + clinica_id + " não existe", HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(clinica, HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Clinica> clinicas = clinicaService.getAll();
        if(clinicas.isEmpty()) {
            return new ResponseEntity<>("Sem clinicas cadastradas", HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(clinicas, HttpStatus.OK);
        }
    }
}
