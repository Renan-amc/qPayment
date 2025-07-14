package com.qpayment.fast.entities.DTO;

import com.qpayment.fast.entities.Charge;

public class ChargeRequestDTO {
	private Long id;
	private String description;
	private Double amount;
	private Integer status;
	private String paymentLink;
	private Long clientId;
	private Long hostId;
	
	public ChargeRequestDTO() {
		
	}

	public ChargeRequestDTO(Long id, String description, Double amount, Integer status, 
			String paymentLink, Long clientId, Long hostId) {
		this.id = id;
		this.description = description;
		this.amount = amount;
		this.status = status;
		this.paymentLink = paymentLink;
		this.clientId = clientId;
		this.hostId = hostId;
	}
	
	public ChargeRequestDTO(Charge charge) {
		this.id = charge.getId();
		this.description = charge.getDescription();
		this.amount = charge.getAmount();
		this.status = charge.getStatus();
		this.paymentLink = charge.getPaymentLink();
		this.clientId = charge.getClient().getId();
		this.hostId = charge.getHost().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getPaymentLink() {
		return paymentLink;
	}

	public void setPaymentLink(String paymentLink) {
		this.paymentLink = paymentLink;
	}

	public Long getClientId() {
		return clientId;
	}
	
	public void setClient(Long clientId) {
		this.clientId = clientId;
	}

	public Long getHostId() {
		return hostId;
	}
	public void setHost(Long hostId) {
		this.hostId = hostId;
	}
	
}
