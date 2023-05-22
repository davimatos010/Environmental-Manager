package com.kraftheinzcompany.model;

import java.time.LocalDate;

public class WaterConsumption {
	private Integer id;
	private Factory factory;
	private double quantity;
	private LocalDate period;
	private String source;
	
	public WaterConsumption(Factory factory, double quantity, LocalDate period, String source) {
		this.factory = factory;
		this.quantity = quantity;
		this.period = period;
		this.source = source;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Factory getFactory() {
		return factory;
	}

	public void setFactory(Factory factory) {
		this.factory = factory;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public LocalDate getPeriod() {
		return period;
	}

	public void setPeriodo(LocalDate period) {
		this.period = period;
	}

	public String getSource() {
		return source;
	}

	public void setFonte(String source) {
		this.source = source;
	}
	
	
}
