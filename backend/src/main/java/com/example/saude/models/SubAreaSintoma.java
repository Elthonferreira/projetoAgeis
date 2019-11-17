package com.example.saude.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sub_area_sintoma")
public class SubAreaSintoma {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_sub_area_sintoma;
	
    private Long sub_area_id;
    private Long sintoma_id;
    
	public SubAreaSintoma() {
		super();
	}

	public SubAreaSintoma(Long id_sub_area_sintoma, Long sub_area_id, Long sintoma_id) {
		super();
		this.id_sub_area_sintoma = id_sub_area_sintoma;
		this.sub_area_id = sub_area_id;
		this.sintoma_id = sintoma_id;
	}

	public Long getId_sub_area_sintoma() {
		return id_sub_area_sintoma;
	}

	public void setId_sub_area_sintoma(Long id_sub_area_sintoma) {
		this.id_sub_area_sintoma = id_sub_area_sintoma;
	}

	public Long getSub_area_id() {
		return sub_area_id;
	}

	public void setSub_area_id(Long sub_area_id) {
		this.sub_area_id = sub_area_id;
	}

	public Long getSintoma_id() {
		return sintoma_id;
	}

	public void setSintoma_id(Long sintoma_id) {
		this.sintoma_id = sintoma_id;
	}

}
