package com.example.saude.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BodyRegion")
public class BodyRegion {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bodyRegionId;

    private Long userId;
    
    private Boolean headFront;
    private Boolean bodyFront;
    private Boolean armLeftFront;
    private Boolean armRightFront;
    private Boolean legLeftFront;
    private Boolean legRightFront;
    
    private Boolean headBack;
    private Boolean bodyBack;
    private Boolean armLeftBack;
    private Boolean armRightBack;
    private Boolean legLeftBack;
    private Boolean legRightBack;
    
    
    public BodyRegion() {
    	
    }
    
	public BodyRegion(Long bodyRegionId, Long userId, Boolean headFront, Boolean bodyFront, Boolean armLeftFront,
			Boolean armRightFront, Boolean legLeftFront, Boolean legRightFront, Boolean headBack, Boolean bodyBack,
			Boolean armLeftBack, Boolean armRightBack, Boolean legLeftBack, Boolean legRightBack) {
		super();
		this.bodyRegionId = bodyRegionId;
		this.userId = userId;
		this.headFront = headFront;
		this.bodyFront = bodyFront;
		this.armLeftFront = armLeftFront;
		this.armRightFront = armRightFront;
		this.legLeftFront = legLeftFront;
		this.legRightFront = legRightFront;
		this.headBack = headBack;
		this.bodyBack = bodyBack;
		this.armLeftBack = armLeftBack;
		this.armRightBack = armRightBack;
		this.legLeftBack = legLeftBack;
		this.legRightBack = legRightBack;
	}

	public Long getBodyRegionId() {
		return bodyRegionId;
	}

	public void setBodyRegionId(Long bodyRegionId) {
		this.bodyRegionId = bodyRegionId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Boolean getHeadFront() {
		return headFront;
	}

	public void setHeadFront(Boolean headFront) {
		this.headFront = headFront;
	}

	public Boolean getBodyFront() {
		return bodyFront;
	}

	public void setBodyFront(Boolean bodyFront) {
		this.bodyFront = bodyFront;
	}

	public Boolean getArmLeftFront() {
		return armLeftFront;
	}

	public void setArmLeftFront(Boolean armLeftFront) {
		this.armLeftFront = armLeftFront;
	}

	public Boolean getArmRightFront() {
		return armRightFront;
	}

	public void setArmRightFront(Boolean armRightFront) {
		this.armRightFront = armRightFront;
	}

	public Boolean getLegLeftFront() {
		return legLeftFront;
	}

	public void setLegLeftFront(Boolean legLeftFront) {
		this.legLeftFront = legLeftFront;
	}

	public Boolean getLegRightFront() {
		return legRightFront;
	}

	public void setLegRightFront(Boolean legRightFront) {
		this.legRightFront = legRightFront;
	}

	public Boolean getHeadBack() {
		return headBack;
	}

	public void setHeadBack(Boolean headBack) {
		this.headBack = headBack;
	}

	public Boolean getBodyBack() {
		return bodyBack;
	}

	public void setBodyBack(Boolean bodyBack) {
		this.bodyBack = bodyBack;
	}

	public Boolean getArmLeftBack() {
		return armLeftBack;
	}

	public void setArmLeftBack(Boolean armLeftBack) {
		this.armLeftBack = armLeftBack;
	}

	public Boolean getArmRightBack() {
		return armRightBack;
	}

	public void setArmRightBack(Boolean armRightBack) {
		this.armRightBack = armRightBack;
	}

	public Boolean getLegLeftBack() {
		return legLeftBack;
	}

	public void setLegLeftBack(Boolean legLeftBack) {
		this.legLeftBack = legLeftBack;
	}

	public Boolean getLegRightBack() {
		return legRightBack;
	}

	public void setLegRightBack(Boolean legRightBack) {
		this.legRightBack = legRightBack;
	}
    
}
