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
	
	/*Precisei Buscar no banco de dados pelo ID do client e retornar o client inteiro para poder obter um 
	construtor no Charge que ao passar um ChargeRequestDTO(somente com a info do ID do cliente/host) eu pudesse ter a informação inteira*/
	
	//Basicamente o que eu quis fazer foi quando eu utilizar o metodo POST eu passase somente o id do client/host e com isso ele busque no banco de dados  ainformação inteira e consiga dar um POST no CHARGE com a info inteira dos CLIENT/HOST
	public Client findByIdComplete(Long clientId) {
		Optional<Client> obj = repository.findById(clientId);
		return obj.orElseThrow(() -> new ResourceNotFoundException(clientId));
	}
	
	public ClientRequestDTO insert(ClientRequestDTO obj) {
		Client client = new Client(obj);
		return new ClientRequestDTO(repository.save(client));
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
	
	public ClientResponseDTO update(Long id, ClientRequestDTO obj) {
		try {
			Client entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return new ClientResponseDTO(repository.save(entity));
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Client entity, ClientRequestDTO obj) {
		entity.setEmail(obj.getEmail());
		entity.setName(obj.getName());
		entity.setPassword(obj.getPassword());
	}

}
