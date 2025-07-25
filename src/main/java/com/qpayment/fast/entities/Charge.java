package com.qpayment.fast.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qpayment.fast.entities.DTO.ChargeRequestDTO;
import com.qpayment.fast.entities.enums.ChargeStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_charge")
public class Charge implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private Double amount;
	private Integer status;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	private String paymentLink;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	@ManyToOne
	@JoinColumn(name = "host_id")
	private Host host;
	
	public Charge() {
		
	}

	public Charge(Long id, String description, Double amount, Instant moment, String paymentLink, ChargeStatus status, Client client, Host host) {
		this.id = id;
		this.description = description;
		this.amount = amount;
		this.moment = moment;
		this.paymentLink = paymentLink;
		setStatus(status);
		this.client = client;
		this.host = host;
	}
	
	public Charge(ChargeRequestDTO chargeDTO, Client client, Host host) {
		this.id = chargeDTO.getId();
		this.description = chargeDTO.getDescription();
		this.amount = chargeDTO.getAmount();
		this.moment = Instant.now();
		this.paymentLink = chargeDTO.getPaymentLink();
		this.status = chargeDTO.getStatus();
		this.client = client;
		this.host = host;
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
	
	public Client getClient() {
		return client;
	}


	public Host getHost() {
		return host;
	}


	public ChargeStatus getStatusValueOf() {
		return ChargeStatus.valueOf(status);
	}
	
	public Integer getStatus(){
		return this.status;
	}

	public void setStatus(ChargeStatus status) {
		if(status != null) {
			this.status = status.getCode();
		}	
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Charge other = (Charge) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
