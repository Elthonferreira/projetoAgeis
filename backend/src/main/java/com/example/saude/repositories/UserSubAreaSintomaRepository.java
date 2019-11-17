package com.example.saude.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.saude.models.UserSubAreaSintoma;

@Repository
public interface UserSubAreaSintomaRepository extends JpaRepository<UserSubAreaSintoma, String>{

}
