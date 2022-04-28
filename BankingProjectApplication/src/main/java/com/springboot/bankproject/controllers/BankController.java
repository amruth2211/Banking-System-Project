package com.springboot.bankproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bankproject.model.Address;
import com.springboot.bankproject.model.Bank;
import com.springboot.bankproject.model.BankAccount;

import com.springboot.bankproject.services.BankService;

@RestController
@RequestMapping("/bank")
public class BankController {

	@Autowired
	BankService bankService;
	
	public List<Bank> getBankNames() {
			return bankService.getBankNames();

	}

    public Integer create(Bank bank)  {

			return bankService.create(bank);

    }
    

    public boolean delete(int bankCode) {
		return bankService.delete(bankCode);

    }


    public Bank update(int bankCode,Address mainOfficAddress) {

		return bankService.update(bankCode,mainOfficAddress);

    }

    public Bank viewBankDetails(int bankCode) {
 		return bankService.viewBankDetails(bankCode);

	}
}
