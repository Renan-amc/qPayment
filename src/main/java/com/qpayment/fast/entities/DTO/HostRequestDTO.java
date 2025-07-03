package com.qpayment.fast.entities.DTO;

import com.qpayment.fast.entities.Host;

public class HostRequestDTO {

	private Long id;
	private String name;
	private String email;
	private String password;
	
	public HostRequestDTO () {
		
	}
	
	public HostRequestDTO (Host host) {
		setId(host.getId());
		setName(host.getName());
		setEmail(host.getEmail());
		setPassword(host.getPassword());
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
