package com.example.saude.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sub_area")
public class SubArea {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    private String nome;
    private Long area_id;
    private Boolean frente;
    private Boolean costas;
    
	public SubArea() {
		super();
	}

	public SubArea(Long id, String nome, Long area_id, Boolean frente, Boolean costas) {
		super();
		this.id = id;
		this.nome = nome;
		this.area_id = area_id;
		this.frente = frente;
		this.costas = costas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getArea_id() {
		return area_id;
	}

	public void setArea_id(Long area_id) {
		this.area_id = area_id;
	}

	public Boolean getFrente() {
		return frente;
	}

	public void setFrente(Boolean frente) {
		this.frente = frente;
	}

	public Boolean getCostas() {
		return costas;
	}

	public void setCostas(Boolean costas) {
		this.costas = costas;
	}

	
	
}
