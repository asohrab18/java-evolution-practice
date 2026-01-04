package com.learning.model;

public class Bank {

	private String name;
	private String city;
	private String state;
	private String country;

	public Bank() {
		System.out.println("Called no-argument constructor of Bank class.");
	}

	public Bank(String name, String city, String state, String country) {
		System.out.println("Called arguments constructor of Bank class.");
		this.name = name;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Name : " + name + ", City: " + city + ", State: " + state + ", Country: " + country + "\n";
	}
}