package com.qpayment.fast.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qpayment.fast.entities.Host;
import com.qpayment.fast.repositories.HostRepository;
import com.qpayment.fast.services.exceptions.ResourceNotFoundException;

@Service
public class HostService {

	@Autowired
	private HostRepository hostRepository;
		
	public List<Host> findAll() {
		return hostRepository.findAll();
	}

	public Host findById(Long id) {
		Optional<Host> obj = hostRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Host insert(Host obj) {
		return hostRepository.save(obj);
	}
	
	public void delete(Long id) {
		hostRepository.deleteById(id);
	}
	
	public Host update(Long id, Host obj) {
		Host entity = hostRepository.getReferenceById(id);
		updateData(entity, obj);
		return hostRepository.save(entity);
	}

	private void updateData(Host entity, Host obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPassword(obj.getPassword());
	}
}
