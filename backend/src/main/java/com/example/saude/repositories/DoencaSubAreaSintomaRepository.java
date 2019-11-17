package com.example.saude.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.saude.models.DoencaSubAreaSintoma;

@Repository
public interface DoencaSubAreaSintomaRepository extends JpaRepository<DoencaSubAreaSintoma, String>{

}
