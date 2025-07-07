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

import com.qpayment.fast.entities.DTO.HostRequestDTO;
import com.qpayment.fast.entities.DTO.HostResponseDTO;
import com.qpayment.fast.services.HostService;

@RestController
@RequestMapping(value = "/hosts")
public class HostResource {
	
	@Autowired
	private HostService hostService;
	
	@GetMapping
	public ResponseEntity<List<HostResponseDTO>> listAll() {
		List<HostResponseDTO> list = hostService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "{id}")   
	public ResponseEntity<HostResponseDTO> findByIdDTO(@PathVariable Long id) {
		HostResponseDTO host = hostService.findById(id);
		return ResponseEntity.ok().body(host);
	}
	
	@PostMapping
	public ResponseEntity<HostRequestDTO> insert(@RequestBody HostRequestDTO obj) {
		obj = hostService.insert(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).body(obj);

	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		hostService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<HostResponseDTO> update(@PathVariable Long id, @RequestBody HostRequestDTO obj) {
		HostResponseDTO entity = hostService.update(id, obj);
		return ResponseEntity.ok().body(entity);
	}
	
}
