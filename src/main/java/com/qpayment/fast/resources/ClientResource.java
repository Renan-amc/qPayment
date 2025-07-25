package com.qpayment.fast.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.qpayment.fast.entities.DTO.ClientRequestDTO;
import com.qpayment.fast.entities.DTO.ClientResponseDTO;
import com.qpayment.fast.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
	
	@Autowired
	private ClientService service;

	@GetMapping
	public ResponseEntity<List<ClientResponseDTO>> findAll() {
		List<ClientResponseDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	} 
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientResponseDTO> findById(@PathVariable Long id) {
		ClientResponseDTO obj = service.findById(id);
		return ResponseEntity.ok().body(obj); 
	}
	
	@PostMapping
	public ResponseEntity<ClientRequestDTO> insert(@RequestBody ClientRequestDTO obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).body(obj);
	} 
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ClientResponseDTO> update(@PathVariable Long id, @RequestBody ClientRequestDTO obj) {
		ClientResponseDTO entity = service.update(id,  obj);
		return ResponseEntity.ok().body(entity);
	}
}
