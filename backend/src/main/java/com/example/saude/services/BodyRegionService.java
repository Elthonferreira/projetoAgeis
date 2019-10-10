package com.example.saude.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.saude.models.BodyRegion;
import com.example.saude.repositories.BodyRegionRepository;

@Service
public class BodyRegionService {
	
	 @Autowired
	    private BodyRegionRepository bodyRegionRepository;

	    public BodyRegion save(BodyRegion bodyRegion) {
	        return bodyRegionRepository.save(bodyRegion);
	    }

	    public List<BodyRegion> getAll() {
	        return bodyRegionRepository.findAll();
	    }
	    
	    public BodyRegion update(BodyRegion bodyRegion) {
	        return bodyRegionRepository.save(bodyRegion);
	    }

	    public void delete(BodyRegion bodyRegion) {
	    	bodyRegionRepository.delete(bodyRegion);
	    }
}
