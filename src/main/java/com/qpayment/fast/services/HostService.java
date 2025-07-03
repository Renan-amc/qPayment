package com.qpayment.fast.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.qpayment.fast.entities.Host;
import com.qpayment.fast.entities.DTO.HostRequestDTO;
import com.qpayment.fast.entities.DTO.HostResponseDTO;
import com.qpayment.fast.repositories.HostRepository;
import com.qpayment.fast.services.exceptions.DataBaseException;
import com.qpayment.fast.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class HostService {

	@Autowired
	private HostRepository hostRepository;
		
	public List<HostResponseDTO> findAll() {
		List<Host> listHost = hostRepository.findAll();
		List<HostResponseDTO> listHostDTO = new ArrayList<>();
		for(Host h : listHost) {
			listHostDTO.add(new HostResponseDTO(h));
		}
		return listHostDTO;
	}
	 
	public HostResponseDTO findById(Long id) {
		Optional<Host> obj = hostRepository.findById(id);
		Host entity = obj.orElseThrow(() -> new ResourceNotFoundException(id));
		return new HostResponseDTO(entity);
	}
	
	public HostRequestDTO insert(HostRequestDTO obj) {
		Host host = new Host(obj);
		host = hostRepository.save(host);
		return new HostRequestDTO(host);
	}
	
	public void delete(Long id) {
		if(!hostRepository.existsById(id)) {
			throw new ResourceNotFoundException(id);
		}
		try {
			hostRepository.deleteById(id);
		} catch(DataIntegrityViolationException e ) {
			throw new DataBaseException(e.getMessage());
		}
	}
	
	public Host update(Long id, Host obj) {
		try {
			Host entity = hostRepository.getReferenceById(id);
			updateData(entity, obj);
			return hostRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Host entity, Host obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPassword(obj.getPassword());
	}
}
