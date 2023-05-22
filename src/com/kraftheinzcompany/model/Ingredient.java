package com.kraftheinzcompany.model;

public class Ingredient {
	private Integer id;
	private boolean sustainable;
	private String name;
	private String origin;
	private int amount;
	
	public Ingredient(boolean sustainable, String name, String origin, int amount) {
		this.sustainable = sustainable;
		this.name = name;
		this.origin = origin;
		this.amount = amount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isSustainable() {
		return sustainable;
	}

	public void setSustainable(boolean sustainable) {
		this.sustainable = sustainable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
