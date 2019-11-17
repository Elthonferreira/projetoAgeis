package com.example.saude.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{diagnosticoId}")
    public ResponseEntity<?> getByUserID(@PathVariable("diagnosticoId") Long diagnosticoId) {
        List<UserSubAreaSintoma> userSubAreaSintomas = userSubAreaSintomaService.getAll();
        List<UserSubAreaSintoma> selectUserSubAreaSintoma = new ArrayList<>();
        
        if(userSubAreaSintomas.isEmpty()) {
            return new ResponseEntity<>("Nenhuma sintoma cadastrado para esse diagnostico.", HttpStatus.NOT_FOUND);
        } else {
            for (UserSubAreaSintoma userSubAreaSintoma: userSubAreaSintomas) {
            	if (userSubAreaSintoma.getId_diagnostico() == diagnosticoId) {
            		selectUserSubAreaSintoma.add(userSubAreaSintoma);
            	}
            }
        }
        
        return new ResponseEntity<>(selectUserSubAreaSintoma, HttpStatus.OK);
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

    @PostMapping
    public ResponseEntity<?> save(@RequestBody UserSubAreaSintoma userSubAreaSintoma) {
    	return new ResponseEntity<>(userSubAreaSintomaService.save(userSubAreaSintoma).getId_user_sub_area_sintoma(), HttpStatus.OK);
    }
    
}
