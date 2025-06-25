package com.qpayment.fast.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qpayment.fast.entities.Client;

@RestController
@RequestMapping(value = "/client")
public class ClientResource {

	@GetMapping
	public ResponseEntity<Client> findAll() {
		Client u = new Client(1L, "Renan", "renanmv10@hotmail.com", "1234");
		return ResponseEntity.ok().body(u);
		
	}
}
