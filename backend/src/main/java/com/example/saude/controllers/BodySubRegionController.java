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

import com.example.saude.models.BodySubRegion;
import com.example.saude.services.BodySubRegionService;

@CrossOrigin("*") // Depois trocar o * pelo endereço do frontend
@RestController
@RequestMapping("/api/bodySubRegion")
public class BodySubRegionController {
	
	@Autowired
    private BodySubRegionService bodySubRegionService;

    @GetMapping("/{bodyRegionId}")
    public ResponseEntity<?> getByUserID(@PathVariable("bodyRegionId") Long bodyRegionId) {
        List<BodySubRegion> bodySubRegions = bodySubRegionService.getAll();
        List<BodySubRegion> userBodyRegions = new ArrayList<>();
        
        if(bodySubRegions.isEmpty()) {
            return new ResponseEntity<>("Nenhuma sub-região cadastrada.", HttpStatus.NOT_FOUND);
        } else {
            for (BodySubRegion bodySubRegion: bodySubRegions) {
            	if (bodySubRegion.getBodyRegionId() == bodyRegionId) {
            		userBodyRegions.add(bodySubRegion);
            	}
            }
        }
        
        return new ResponseEntity<>(userBodyRegions, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody BodySubRegion bodySubRegion) {
    	return new ResponseEntity<>(bodySubRegionService.save(bodySubRegion).getBodyRegionId(), HttpStatus.OK);
    }
    
}
