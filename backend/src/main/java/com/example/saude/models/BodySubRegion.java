package com.example.saude.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BodySubRegion")
public class BodySubRegion {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bodySubegionId;
	
	private Long bodyRegionId;
    private String bodyRegion;
    private String bodySubRegion;
    private String symptom;
    private Boolean front;
    
	public BodySubRegion() {
		super();
	}

	public BodySubRegion(Long bodySubegionId, Long bodyRegionId, String bodyRegion, String bodySubRegion,
			String symptom, Boolean front) {
		super();
		this.bodySubegionId = bodySubegionId;
		this.bodyRegionId = bodyRegionId;
		this.bodyRegion = bodyRegion;
		this.bodySubRegion = bodySubRegion;
		this.symptom = symptom;
		this.front = front;
	}

	public Long getBodySubegionId() {
		return bodySubegionId;
	}

	public void setBodySubegionId(Long bodySubegionId) {
		this.bodySubegionId = bodySubegionId;
	}

	public Long getBodyRegionId() {
		return bodyRegionId;
	}

	public void setBodyRegionId(Long bodyRegionId) {
		this.bodyRegionId = bodyRegionId;
	}

	public String getBodyRegion() {
		return bodyRegion;
	}

	public void setBodyRegion(String bodyRegion) {
		this.bodyRegion = bodyRegion;
	}

	public String getBodySubRegion() {
		return bodySubRegion;
	}

	public void setBodySubRegion(String bodySubRegion) {
		this.bodySubRegion = bodySubRegion;
	}

	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public Boolean getFront() {
		return front;
	}

	public void setFront(Boolean front) {
		this.front = front;
	}

}
