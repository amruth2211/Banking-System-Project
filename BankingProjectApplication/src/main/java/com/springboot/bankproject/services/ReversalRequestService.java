package com.springboot.bankproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bankproject.model.ReversalRequests;

import com.springboot.bankproject.repository.ReversalRequestRepository;

@Service
public class ReversalRequestService {

	@Autowired
	ReversalRequestRepository ReversalRequestRepo;
	
	
    public List<ReversalRequests> getRequests() 
        {
    		try {
    			return ReversalRequestRepo.getRequests();
    		}
    		catch(Exception e) {
    			System.out.println(e);
    			return null;
    		}
        }

}
