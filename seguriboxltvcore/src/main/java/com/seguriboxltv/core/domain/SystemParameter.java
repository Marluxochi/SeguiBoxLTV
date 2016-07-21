package com.seguriboxltv.core.domain;



public class SystemParameter {

	private String parameterName;
	private String parameterValue;
	private String category;

	public SystemParameter() {
	}

	public SystemParameter(String parameterName) {
		this.parameterName = parameterName;
	}

	public SystemParameter(String parameterName, String parameterValue, String category) {
		this.parameterName = parameterName;
		this.parameterValue = parameterValue;
		this.category = category;
	}

	public String getParameterName() {
		return this.parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getParameterValue() {
		return this.parameterValue;
	}

	public void setParameterValue(String parameterValue) {
		this.parameterValue = parameterValue;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
