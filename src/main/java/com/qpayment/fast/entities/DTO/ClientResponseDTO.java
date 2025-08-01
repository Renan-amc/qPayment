package com.qpayment.fast.entities.DTO;

import java.util.ArrayList;
import java.util.List;

import com.qpayment.fast.entities.Charge;
import com.qpayment.fast.entities.Client;

public class ClientResponseDTO {

	private Long id;
	private String name;
	private String email;
	private List<Long> chargeIds = new ArrayList<>();
	
	public ClientResponseDTO() {
		
	}

	public ClientResponseDTO(Long id, String name, String email, List<Long> chargeIds) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.chargeIds = chargeIds;
	}
	
	public ClientResponseDTO(Client client) {
		setId(client.getId());
		setName(client.getName());
		setEmail(client.getEmail());
		setCharge(client.getCharges());
	}
	
	private void setCharge(List<Charge> charges) {
		for(Charge c : charges) {
			this.chargeIds.add(c.getId());
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Long> getChargeIds() {
		return chargeIds;
	}
	
	
}
