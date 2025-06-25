package com.qpayment.fast.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qpayment.fast.entities.Charge;
import com.qpayment.fast.repositories.ChargeRepository;

@Service
public class ChargeService {
	
	@Autowired
	private ChargeRepository repository;
	
	public List<Charge> findAll() {
		return repository.findAll();
	}
	
	public Charge findById(Long id){
		Optional<Charge> obj = repository.findById(id);
		return obj.get();
	}
}
