package br.com.eberts.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eberts.domain.Cliente;
import br.com.eberts.services.ClienteService;

@RestController
@RequestMapping(value = "clientes")
public class ClienteResource {
	
	private final ClienteService clienteService;
	
	public ClienteResource (ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findOne(@PathVariable Integer id) {
		
		Cliente cli  = clienteService.findById(id);
		return ResponseEntity.ok(cli);
	}
	
	@GetMapping
	public List<Cliente> findAll() {
		
		return clienteService.findAll();

	}
	

}
