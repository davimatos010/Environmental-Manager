package com.kraftheinzcompany.model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Batch {
	private int id;
	private Factory factory;
	private Packaging packaging;
	private String product;
	private List<Ingredient> ingredients = new ArrayList<Ingredient>();
	private LocalDate fabricationDate;
	private LocalDate expirationDate;
	
	public Batch(Factory factory, Packaging packaging, String product, List<Ingredient> ingredients, LocalDate fabricationDate, LocalDate expirationDate) {
		this.factory = factory;
		this.packaging = packaging;
		this.product = product;
		this.ingredients = ingredients;
		this.fabricationDate = fabricationDate;
		this.expirationDate = expirationDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Factory getFactory() {
		return factory;
	}

	public void setFabrica(Factory factory) {
		this.factory = factory;
	}

	public Packaging getPackaging() {
		return packaging;
	}

	public void setPackaging(Packaging packaging) {
		this.packaging = packaging;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public LocalDate getFabricationDate() {
		return fabricationDate;
	}

	public void setFabricationDate(LocalDate fabricationDate) {
		this.fabricationDate = fabricationDate;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	
	
}
