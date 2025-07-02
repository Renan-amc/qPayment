package com.qpayment.fast.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qpayment.fast.entities.Client;
import com.qpayment.fast.repositories.ClientRepository;
import com.qpayment.fast.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	public List<Client> findAll() {
		return repository.findAll();
	}
	
	public Client findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Client insert(Client obj) {
		return repository.save(obj);
	}
	
	public Client update(Long id, Client obj) {
		Client entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Client entity, Client obj) {
		entity.setEmail(obj.getEmail());
		entity.setName(obj.getName());
		entity.setPassword(obj.getPassword());
	}
}
