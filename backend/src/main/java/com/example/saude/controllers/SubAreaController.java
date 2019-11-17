package com.example.saude.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.saude.models.SubArea;
import com.example.saude.services.SubAreaService;

@CrossOrigin("*") // Depois trocar o * pelo endereço do frontend
@RestController
@RequestMapping("/api/subarea")
public class SubAreaController {
	
	@Autowired
    private SubAreaService subAreaService;

    @GetMapping("/{areaId}")
    public ResponseEntity<?> getByUserID(@PathVariable("areaId") Long areaId) {
        List<SubArea> subAreas = subAreaService.getAll();
        List<SubArea> selectSubAreas = new ArrayList<>();
        
        if(subAreas.isEmpty()) {
            return new ResponseEntity<>("Nenhuma sub-região cadastrada.", HttpStatus.NOT_FOUND);
        } else {
            for (SubArea subArea: subAreas) {
            	if (subArea.getArea_id() == areaId) {
            		selectSubAreas.add(subArea);
            	}
            }
        }
        
        return new ResponseEntity<>(selectSubAreas, HttpStatus.OK);
    }

    @GetMapping("/first/{subAreaId}")
    public ResponseEntity<?> getByCpf(@PathVariable("subAreaId") Long subAreaId) {
        SubArea subArea = subAreaService.getById(subAreaId);
        if(subArea == null) {
            return new ResponseEntity<>("Sub área com id " + subAreaId + " não existe", HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(subArea, HttpStatus.OK);
        }
    }
    
//    @PostMapping
//    public ResponseEntity<?> save(@RequestBody SubArea subArea) {
//    	return new ResponseEntity<>(subAreaService.save(subArea).getId_sub_area(), HttpStatus.OK);
//    }
    
}
