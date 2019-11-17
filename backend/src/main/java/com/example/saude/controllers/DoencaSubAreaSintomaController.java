package com.example.saude.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.saude.models.DoencaSubAreaSintoma;
import com.example.saude.services.DoencaSubAreaSintomaService;

@CrossOrigin("*") // Depois trocar o * pelo endereço do frontend
@RestController
@RequestMapping("/api/doencasubareasintoma")
public class DoencaSubAreaSintomaController {
	
	@Autowired
    private DoencaSubAreaSintomaService doencaSubAreaSintomaService;

    @GetMapping("/{subAreaSintomaId}")
    public ResponseEntity<?> getByUserID(@PathVariable("subAreaSintomaId") Long subAreaSintomaId) {
        List<DoencaSubAreaSintoma> doencaSubAreaSintomas = doencaSubAreaSintomaService.getAll();
        
        if(doencaSubAreaSintomas.isEmpty()) {
            return new ResponseEntity<>("Nenhuma doenca contem esse sintoma.", HttpStatus.NOT_FOUND);
        } else {
            for (DoencaSubAreaSintoma doencaSubAreaSintoma: doencaSubAreaSintomas) {
            	if (doencaSubAreaSintoma.getSub_area_sintoma_id() == subAreaSintomaId) {
            		return new ResponseEntity<>(doencaSubAreaSintoma.getDoenca_id(), HttpStatus.OK);
            	}
            }
        }
        
        return new ResponseEntity<>(-1, HttpStatus.OK);
    }
    
    @GetMapping("/countSintomas/{doencaId}")
    public ResponseEntity<?> getCountSintoma(@PathVariable("doencaId") Long doencaId) {
        List<DoencaSubAreaSintoma> doencaSubAreaSintomas = doencaSubAreaSintomaService.getAll();
        int countSintoma = 0;
        
        if(doencaSubAreaSintomas.isEmpty()) {
            return new ResponseEntity<>("Nenhum sintoma encontrado.", HttpStatus.NOT_FOUND);
        } else {
            for (DoencaSubAreaSintoma doencaSubAreaSintoma: doencaSubAreaSintomas) {
            	if (doencaSubAreaSintoma.getDoenca_id() == doencaId) {
            		countSintoma++;
            	}
            }
        }
        
        return new ResponseEntity<>(countSintoma, HttpStatus.OK);
    }
    
//    
//    @GetMapping("/{subAreaId}/{sintomaId}")
//    public ResponseEntity<?> getByUserID(@PathVariable("subAreaId") Long subAreaId, @PathVariable("sintomaId") Long sintomaId) {
//        List<SubAreaSintoma> subAreaSintomas = subAreaSintomaService.getAll();
//        
//        if(subAreaSintomas.isEmpty()) {
//            return new ResponseEntity<>("Nenhuma sub area - sintoma cadastrado.", HttpStatus.NOT_FOUND);
//        } else {
//            for (SubAreaSintoma subAreaSintoma: subAreaSintomas) {
//            	if (subAreaSintoma.getSub_area_id() == subAreaId && subAreaSintoma.getSintoma_id() == sintomaId) {
//            		return new ResponseEntity<>(subAreaSintoma.getId_sub_area_sintoma(), HttpStatus.OK);
//            	}
//            }
//        }
//        
//        return new ResponseEntity<>(-1, HttpStatus.OK);
//    }

//    @PostMapping
//    public ResponseEntity<?> save(@RequestBody UserSubAreaSintoma userSubAreaSintoma) {
//    	return new ResponseEntity<>(userSubAreaSintomaService.save(userSubAreaSintoma).getId_user_sub_area_sintoma(), HttpStatus.OK);
//    }
//    
}
