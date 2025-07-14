package com.qpayment.fast.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qpayment.fast.entities.Charge;
import com.qpayment.fast.entities.Client;
import com.qpayment.fast.entities.Host;
import com.qpayment.fast.entities.DTO.ChargeRequestDTO;
import com.qpayment.fast.entities.DTO.ChargeResponseDTO;
import com.qpayment.fast.repositories.ChargeRepository;
import com.qpayment.fast.services.exceptions.ResourceNotFoundException;

@Service
public class ChargeService {
	
	@Autowired
	private ChargeRepository repository;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private HostService hostService;
	
	public List<ChargeResponseDTO> findAll() {
		List<Charge> listCharge = repository.findAll();
		List<ChargeResponseDTO> listChargeDTO = new ArrayList<>();
		for(Charge c : listCharge) {
			listChargeDTO.add(new ChargeResponseDTO(c));
		}
		return listChargeDTO;
	}
	
	public ChargeResponseDTO findById(Long id){
		Optional<Charge> obj = repository.findById(id);
		Charge charge = obj.orElseThrow(() -> new ResourceNotFoundException(id));
		return new ChargeResponseDTO(charge);
	}
	
	public ChargeRequestDTO insert(ChargeRequestDTO obj) {
		//tive que ter uma associação aos serviços de client e host e buscar eles pelos ID's pra conseguir dar um post com o valor inteiro do host/client 
		Client client = clientService.findByIdComplete(obj.getClientId());
		Host host = hostService.findByIdComplete(obj.getHostId());
		
		Charge charge = new Charge(obj, client, host);
		
		return new ChargeRequestDTO(repository.save(charge));
	}
}
