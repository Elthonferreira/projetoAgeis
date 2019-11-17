package com.example.saude.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sintomas")
public class Sintoma {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    private String nome;
    
	public Sintoma() {
		super();
	}

	public Sintoma(Long id_sintoma, String nome) {
		super();
		this.id = id_sintoma;
		this.nome = nome;
	}

	public Long getId_sintoma() {
		return id;
	}

	public void setId_sintoma(Long id_sintoma) {
		this.id = id_sintoma;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
