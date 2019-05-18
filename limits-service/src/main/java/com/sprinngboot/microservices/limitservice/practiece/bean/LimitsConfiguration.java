package com.sprinngboot.microservices.limitservice.practiece.bean;

public class LimitsConfiguration {

	private int minimum;
	private int maximum;
	
	public LimitsConfiguration(int minimum, int maximum) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}
	
	public int getMinimum() {
		return minimum;
	}
	
	public int getMaximum() {
		return maximum;
	}
	
	
}
