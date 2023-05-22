package com.kraftheinzcompany.model;

public class Address {
	private Integer zipCode;
	private String city;
	private String neighborhood;
	private String street;
	private Integer streetNumber;
	private String complement;
	
	public Address(Integer zipCode, String city, String neighborhood, String street, Integer streetNumber, String complement) {
		this.zipCode = zipCode;
		this.city = city;
		this.neighborhood = neighborhood;
		this.street = street;
		this.streetNumber = streetNumber;
		this.complement = complement;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(Integer streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}
	
	
	
}
