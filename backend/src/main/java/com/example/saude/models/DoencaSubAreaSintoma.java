package com.example.saude.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doenca_sub_area_sintoma")
public class DoencaSubAreaSintoma {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long 	id_doenca_sub_area_sintoma;
	
    private Long doenca_id;
    private Long sub_area_sintoma_id;
    
	public DoencaSubAreaSintoma() {
		super();
	}

	public DoencaSubAreaSintoma(Long id_doenca_sub_area_sintoma, Long doenca_id, Long sub_area_sintoma_id) {
		super();
		this.id_doenca_sub_area_sintoma = id_doenca_sub_area_sintoma;
		this.doenca_id = doenca_id;
		this.sub_area_sintoma_id = sub_area_sintoma_id;
	}

	public Long getId_doenca_sub_area_sintoma() {
		return id_doenca_sub_area_sintoma;
	}

	public void setId_doenca_sub_area_sintoma(Long id_doenca_sub_area_sintoma) {
		this.id_doenca_sub_area_sintoma = id_doenca_sub_area_sintoma;
	}

	public Long getDoenca_id() {
		return doenca_id;
	}

	public void setDoenca_id(Long doenca_id) {
		this.doenca_id = doenca_id;
	}

	public Long getSub_area_sintoma_id() {
		return sub_area_sintoma_id;
	}

	public void setSub_area_sintoma_id(Long sub_area_sintoma_id) {
		this.sub_area_sintoma_id = sub_area_sintoma_id;
	}

}
