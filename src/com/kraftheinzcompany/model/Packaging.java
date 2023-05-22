package com.kraftheinzcompany.model;

public class Packaging {
	private Integer id;
	private String material;
	private boolean recyclable;
	
	public Packaging(String material, boolean recyclable) {
		this.material = material;
		this.recyclable = recyclable;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public boolean isRecyclable() {
		return recyclable;
	}

	public void setRecyclable(boolean recyclable) {
		this.recyclable = recyclable;
	}
	
	
}
