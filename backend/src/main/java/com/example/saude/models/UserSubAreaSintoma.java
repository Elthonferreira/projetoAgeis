package com.example.saude.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_sub_area_sintoma")
public class UserSubAreaSintoma {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_user_sub_area_sintoma;
	
    private Long user_id;
    private Long sub_area_sintoma_id;
    
	public UserSubAreaSintoma() {
		super();
	}

	public UserSubAreaSintoma(Long id_user_sub_area_sintoma, Long user_id, Long sub_area_sintoma_id) {
		super();
		this.id_user_sub_area_sintoma = id_user_sub_area_sintoma;
		this.user_id = user_id;
		this.sub_area_sintoma_id = sub_area_sintoma_id;
	}

	public Long getId_user_sub_area_sintoma() {
		return id_user_sub_area_sintoma;
	}

	public void setId_user_sub_area_sintoma(Long id_user_sub_area_sintoma) {
		this.id_user_sub_area_sintoma = id_user_sub_area_sintoma;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Long getSub_area_sintoma_id() {
		return sub_area_sintoma_id;
	}

	public void setSub_area_sintoma_id(Long sub_area_sintoma_id) {
		this.sub_area_sintoma_id = sub_area_sintoma_id;
	}

}
