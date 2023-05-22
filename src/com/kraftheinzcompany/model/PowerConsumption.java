package com.kraftheinzcompany.model;

import java.time.LocalDate;

public class PowerConsumption {
	private Integer id;
	private Factory factory;
	private double quantity;
	private LocalDate period;
	private String source;
	private String type;
	
	public PowerConsumption(Factory factory, double quantity, LocalDate period, String source, String type) {
		this.factory = factory;
		this.quantity = quantity;
		this.period = period;
		this.source = source;
		this.type = type;
		
		
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

	public void setPeriod(LocalDate period) {
		this.period = period;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
