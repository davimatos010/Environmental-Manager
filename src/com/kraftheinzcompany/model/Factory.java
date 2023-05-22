package com.kraftheinzcompany.model;

public class Factory {
	private Integer id;
	private Address address;
	private String document;
	private boolean inRiskArea;
	
	public Factory (Address address, String document, boolean inRiskArea) {
		this.address = address;
		this.document = document;
		this.inRiskArea = inRiskArea;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAdress(Address address) {
		this.address = address;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public boolean isInRiskArea() {
		return inRiskArea;
	}

	public void setInRiskArea(boolean inRiskArea) {
		this.inRiskArea = inRiskArea;
	}
	
	
}
