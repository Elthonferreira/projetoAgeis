package com.example.saude.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "diagnostico")
public class Diagnostico {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_diagnostico;
	
    private Long id_user;
    
	public Diagnostico() {
		super();
	}

	public Diagnostico(Long id_diagnostico, Long id_user) {
		super();
		this.id_diagnostico = id_diagnostico;
		this.id_user = id_user;
	}

	public Long getId_diagnostico() {
		return id_diagnostico;
	}

	public void setId_diagnostico(Long id_diagnostico) {
		this.id_diagnostico = id_diagnostico;
	}

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

}
