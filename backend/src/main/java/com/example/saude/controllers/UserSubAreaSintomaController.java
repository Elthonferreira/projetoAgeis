package com.example.saude.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.saude.models.UserSubAreaSintoma;
import com.example.saude.services.UserSubAreaSintomaService;

@CrossOrigin("*") // Depois trocar o * pelo endereço do frontend
@RestController
@RequestMapping("/api/usersubareasintoma")
public class UserSubAreaSintomaController {
	
	@Autowired
    private UserSubAreaSintomaService userSubAreaSintomaService;

//    @GetMapping("/{subAreaId}")
//    public ResponseEntity<?> getByUserID(@PathVariable("subAreaId") Long subAreaId) {
//        List<SubAreaSintoma> subAreaSintomas = subAreaSintomaService.getAll();
//        List<Sintoma> selectSubAreaSintomas = new ArrayList<>();
//        
//        if(subAreaSintomas.isEmpty()) {
//            return new ResponseEntity<>("Nenhuma sintoma cadastrado.", HttpStatus.NOT_FOUND);
//        } else {
//            for (SubAreaSintoma subAreaSintoma: subAreaSintomas) {
//            	if (subAreaSintoma.getSub_area_id() == subAreaId) {
//            		selectSubAreaSintomas.add(sintomaService.getById(subAreaSintoma.getSintoma_id()));
//            	}
//            }
//        }
//        
//        return new ResponseEntity<>(selectSubAreaSintomas, HttpStatus.OK);
//    }
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

    @PostMapping
    public ResponseEntity<?> save(@RequestBody UserSubAreaSintoma userSubAreaSintoma) {
    	return new ResponseEntity<>(userSubAreaSintomaService.save(userSubAreaSintoma).getId_user_sub_area_sintoma(), HttpStatus.OK);
    }
    
}
