package com.example.saude.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.saude.models.SubArea;

@Repository
public interface SubAreaRepository extends JpaRepository<SubArea, String>{
	public SubArea findById(Long id);
}
