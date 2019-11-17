package com.example.saude.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.saude.models.SubAreaSintoma;

@Repository
public interface SubAreaSintomaRepository extends JpaRepository<SubAreaSintoma, String>{

}
