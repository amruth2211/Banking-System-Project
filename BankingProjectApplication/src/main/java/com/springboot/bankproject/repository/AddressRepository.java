package com.springboot.bankproject.repository;

import com.springboot.bankproject.model.Address;

public class AddressRepository {
	public static Address processAddress(String address) {
		String[] addressArray = address.split(",");

		return new Address(addressArray[0], addressArray[1], addressArray[2], addressArray[3],
				Integer.parseInt(addressArray[4].trim()));
	}
}
