package com.qpayment.fast.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qpayment.fast.entities.Charge;
import com.qpayment.fast.entities.Client;
import com.qpayment.fast.services.ChargeService;


@RestController
@RequestMapping(value = "/charges")
public class ChargeResource {

	@Autowired
	private ChargeService service;
	
	@GetMapping
	public ResponseEntity<List<Charge>> findAll() {
		List<Charge> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Charge> findById(@PathVariable Long id) {
		Charge obj = service.findById(id);
		return ResponseEntity.ok().body(obj); 
	}
}
