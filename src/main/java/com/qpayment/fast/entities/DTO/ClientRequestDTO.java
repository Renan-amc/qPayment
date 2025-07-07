package com.qpayment.fast.entities.DTO;

import com.qpayment.fast.entities.Client;

public class ClientRequestDTO {

	private Long id;
	private String name;
	private String email;
	private String password;
	
	public ClientRequestDTO() {
		
	}

	public ClientRequestDTO(Long id, String name, String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public ClientRequestDTO(Client client) {
		setId(client.getId());
		setName(client.getName());
		setEmail(client.getEmail());
		setPassword(client.getPassword());
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
