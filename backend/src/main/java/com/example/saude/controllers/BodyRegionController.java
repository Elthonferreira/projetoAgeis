package com.example.saude.controllers;

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

import com.example.saude.models.BodyRegion;
import com.example.saude.services.BodyRegionService;

@CrossOrigin("*") // Depois trocar o * pelo endereço do frontend
@RestController
@RequestMapping("/api/bodyregion")
public class BodyRegionController {
	
	@Autowired
    private BodyRegionService bodyRegionService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getAllByUserID(@PathVariable("id") Long id) {
        List<BodyRegion> bodyRegions = bodyRegionService.getAll();
        if(bodyRegions.isEmpty()) {
            return new ResponseEntity<>("Nenhuma região corporal cadastrada", HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(bodyRegions, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody BodyRegion bodyRegion) {
    	
    	return new ResponseEntity<>(bodyRegionService.save(bodyRegion), HttpStatus.OK);
        
    }
    
}
