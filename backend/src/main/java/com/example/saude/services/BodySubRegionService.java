package com.example.saude.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.saude.models.BodySubRegion;
import com.example.saude.repositories.BodySubRegionRepository;

@Service
public class BodySubRegionService {
	
	 @Autowired
	 private BodySubRegionRepository bodySubRegionRepository;

	 public BodySubRegion save(BodySubRegion bodySubRegion) {
	    return bodySubRegionRepository.save(bodySubRegion);
	 }

	 public List<BodySubRegion> getAll() {
	     return bodySubRegionRepository.findAll();
	 }
	    
	 public BodySubRegion update(BodySubRegion bodySubRegion) {
	     return bodySubRegionRepository.save(bodySubRegion);
	 }

	 public void delete(BodySubRegion bodySubRegion) {
		 bodySubRegionRepository.delete(bodySubRegion);
	 }
}
