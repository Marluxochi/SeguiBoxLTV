package com.seguriboxltv.core.domain;

import java.util.Date;


public class Area  {

	private short areaId;
	private String areaName;
	private Boolean isActive;
	private Date referenceDate;
	

	public Area() {
	}

	public Area(short areaId, Date referenceDate) {
		this.areaId = areaId;
		this.referenceDate = referenceDate;
	}

	public Area(short areaId, String areaName, Boolean isActive, Date referenceDate) {
		this.areaId = areaId;
		this.areaName = areaName;
		this.isActive = isActive;
		this.referenceDate = referenceDate;
		
	}

	public int getAreaId() {
		return this.areaId;
	}

	public void setAreaId(short i) {
		this.areaId = i;
	}

	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Date getReferenceDate() {
		return this.referenceDate;
	}

	public void setReferenceDate(Date referenceDate) {
		this.referenceDate = referenceDate;
	}

	@Override
	public String toString() {
		return "Area [areaId=" + areaId + ", areaName=" + areaName + ", isActive=" + isActive + ", referenceDate="
				+ referenceDate + "]";
	}



}
