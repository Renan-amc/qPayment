package com.qpayment.fast.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.qpayment.fast.entities.DTO.ChargeRequestDTO;
import com.qpayment.fast.entities.DTO.ChargeResponseDTO;
import com.qpayment.fast.services.ChargeService;


@RestController
@RequestMapping(value = "/charges")
public class ChargeResource {

	@Autowired
	private ChargeService service;
	
	@GetMapping
	public ResponseEntity<List<ChargeResponseDTO>> findAll() {
		List<ChargeResponseDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ChargeResponseDTO> findById(@PathVariable Long id) {
		ChargeResponseDTO obj = service.findById(id);
		return ResponseEntity.ok().body(obj); 
	}
	
	@PostMapping
	public ResponseEntity<ChargeRequestDTO> insert(@RequestBody ChargeRequestDTO obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
