package com.springboot.bankproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bankproject.model.Admin;
import com.springboot.bankproject.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepo;
	
	 public Admin viewProfile(Integer adminID)
	 {
		 try {
			 return adminRepo.viewProfile(adminID);
			}
			catch(Exception e) {
				System.out.println(e);
				return null;
			}
	 }
}
