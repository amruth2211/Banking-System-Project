package com.springboot.bankproject.model;

public class Address {
    String street;
    String city;
    String state;
    String country;
    Integer pinCode;

    public Address(String street, String city, String state, String country, Integer pinCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pinCode = pinCode;
    }

    public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	@Override
    public String toString() {
        return   street + "," + city + "," + state + "," + country
                + "," + pinCode ;
    }

}
