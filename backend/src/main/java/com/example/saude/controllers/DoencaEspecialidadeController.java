package com.example.saude.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/doenca/{doencaId}")
    public ResponseEntity<?> getByDoencaId(@PathVariable("doencaId") Long doencaId) {
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
    
    @GetMapping("/clinica/{clinicaId}")
    public ResponseEntity<?> getByClinicaId(@PathVariable("clinicaId") Long clinicaId) {
        List<DoencaEspecialidade> doencaEspecialidades = doencaEspecialidadeService.getAll();
        List<DoencaEspecialidade> selectDoencaEspecialidades = new ArrayList<>();
        
        if(doencaEspecialidades.isEmpty()) {
            return new ResponseEntity<>("Nenhuma clinica encontrada.", HttpStatus.NOT_FOUND);
        } else {
            for (DoencaEspecialidade doencaEspecialidade: doencaEspecialidades) {
            	if (doencaEspecialidade.getClinica_id() == clinicaId) {
            		selectDoencaEspecialidades.add(doencaEspecialidade);
            	}
            }
        }
        
        return new ResponseEntity<>(selectDoencaEspecialidades, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> save(@RequestBody DoencaEspecialidade doencaEspecialidade) {
    	return new ResponseEntity<>(doencaEspecialidadeService.save(doencaEspecialidade).getId(), HttpStatus.OK);
    }
    
    @PostMapping("/{doencaEspecialidadeId}")
    public ResponseEntity<?> delete(@PathVariable("doencaEspecialidadeId") Long doencaEspecialidadeId) {
    	System.out.print(doencaEspecialidadeId);
    	DoencaEspecialidade aux = doencaEspecialidadeService.getById(doencaEspecialidadeId);
        if(aux == null) {
            return new ResponseEntity<>("Especialidade não existe!", HttpStatus.NOT_FOUND);
        }
        else {
            doencaEspecialidadeService.delete(aux);
            return new ResponseEntity<>("Especialidade excluída!", HttpStatus.OK);
        }
    }
}
