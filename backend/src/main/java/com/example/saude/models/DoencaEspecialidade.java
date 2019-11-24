package com.example.saude.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doenca_especialidade")
public class DoencaEspecialidade {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    private Long doenca_id;
    private Long especialidade_id;
    private Long clinica_id;
    
	public DoencaEspecialidade() {
		super();
	}

	public DoencaEspecialidade(Long id, Long doenca_id, Long especialidade_id, Long clinica_id) {
		super();
		this.id = id;
		this.doenca_id = doenca_id;
		this.especialidade_id = especialidade_id;
		this.clinica_id = clinica_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDoenca_id() {
		return doenca_id;
	}

	public void setDoenca_id(Long doenca_id) {
		this.doenca_id = doenca_id;
	}

	public Long getEspecialidade_id() {
		return especialidade_id;
	}

	public void setEspecialidade_id(Long especialidade_id) {
		this.especialidade_id = especialidade_id;
	}

	public Long getClinica_id() {
		return clinica_id;
	}

	public void setClinica_id(Long clinica_id) {
		this.clinica_id = clinica_id;
	}
	
}
