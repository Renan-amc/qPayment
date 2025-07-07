package com.qpayment.fast.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.qpayment.fast.entities.Client;
import com.qpayment.fast.entities.DTO.ClientRequestDTO;
import com.qpayment.fast.entities.DTO.ClientResponseDTO;
import com.qpayment.fast.repositories.ClientRepository;
import com.qpayment.fast.services.exceptions.DataBaseException;
import com.qpayment.fast.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	public List<ClientResponseDTO> findAll() {
		List<Client> listClient = repository.findAll();
		List<ClientResponseDTO> listClientDTO = new ArrayList<>();
		for(Client c : listClient) {
			listClientDTO.add(new ClientResponseDTO(c));
		}
		return listClientDTO;
	}
	
	public ClientResponseDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client client = obj.orElseThrow(() -> new ResourceNotFoundException(id));
		return new ClientResponseDTO(client);
	}
	
	public ClientRequestDTO insert(ClientRequestDTO obj) {
		Client client = new Client(obj);
		client = repository.save(client);
		return new ClientRequestDTO(client);
	}
	
	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException(id);
		}
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}
	
	public Client update(Long id, Client obj) {
		try {
			Client entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Client entity, Client obj) {
		entity.setEmail(obj.getEmail());
		entity.setName(obj.getName());
		entity.setPassword(obj.getPassword());
	}
}
