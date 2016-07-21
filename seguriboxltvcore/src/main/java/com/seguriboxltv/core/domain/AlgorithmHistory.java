package com.seguriboxltv.core.domain;

import java.util.Date;

//Clase dominio que representa las propiedades de la tabla AlgorithmHistory

public class AlgorithmHistory {
	int eventId;
	Date dateReference;
	int userId;
	String hostName;
	String action;
	String details;

	public AlgorithmHistory(){}
	
	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public Date getDateReference() {
		return dateReference;
	}

	public void setDateReference(Date dateReference) {
		this.dateReference = dateReference;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
