package com.example.saude.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.saude.models.BodySubRegion;

@Repository
public interface BodySubRegionRepository extends JpaRepository<BodySubRegion, String>{

}
