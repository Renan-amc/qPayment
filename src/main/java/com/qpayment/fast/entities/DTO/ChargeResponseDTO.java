package com.qpayment.fast.entities.DTO;

import java.time.Instant;

import com.qpayment.fast.entities.Charge;

public class ChargeResponseDTO {
	private Long id;
	private String description;
	private Double amount;
	private Integer status;
	private Instant moment;
	private String paymentLink;
	private Long clientId;
	private Long hostId;
	
	
	public ChargeResponseDTO() {
		
	}
	
	public ChargeResponseDTO(Long id, String description, Double amount, Integer status, Instant moment,
			String paymentLink, Long clientId, Long hostId) {
		this.id = id;
		this.description = description;
		this.amount = amount;
		this.status = status;
		this.moment = moment;
		this.paymentLink = paymentLink;
		this.clientId = clientId;
		this.hostId = hostId;
	}
	
	public ChargeResponseDTO(Charge charge) {
		this.id = charge.getId();
		this.description = charge.getDescription();
		this.amount = charge.getAmount();
		this.status = charge.getStatus();
		this.moment = charge.getMoment();
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

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public String getPaymentLink() {
		return paymentLink;
	}

	public void setPaymentLink(String paymentLink) {
		this.paymentLink = paymentLink;
	}

	public Long getClient() {
		return clientId;
	}
	
	public void setClient(Long clientId) {
		this.clientId = clientId;
	}

	public Long getHost() {
		return hostId;
	}
	
	public void setHost(Long hostId) {
		this.hostId = hostId;
	}
	
}
