package com.qpayment.fast.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qpayment.fast.entities.Host;
import com.qpayment.fast.repositories.HostRepository;

@Service
public class HostService {

	@Autowired
	private HostRepository hostRepository;
		
	public List<Host> findAll() {
		return hostRepository.findAll();
	}

	public Host findById(Long id) {
		Optional<Host> obj = hostRepository.findById(id);
		return obj.get();
	}
	
	public Host insert(Host obj) {
		return hostRepository.save(obj);
	}
	
	public void delete(Long id) {
		hostRepository.deleteById(id);
	}
	
}
