package br.com.eberts.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.eberts.domain.Cliente;
import br.com.eberts.domain.Cliente;
import br.com.eberts.dto.ClienteDTO;
import br.com.eberts.services.ClienteService;
import jakarta.validation.Valid;

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
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody @Valid ClienteDTO catDto,@PathVariable Integer id) {
		Cliente cat = clienteService.fromDto(catDto);
		cat.setId(id);
		cat = clienteService.update(cat);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Cliente> delete(@PathVariable Integer id) {
		
		clienteService.DeleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll() {
		
		List<Cliente> lista =  clienteService.findAll();
		List<ClienteDTO> listaDTO = lista.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok(listaDTO);

	}
	@GetMapping(value = "/page")
	public ResponseEntity<Page<ClienteDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "5") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		
		Page<Cliente> lista =  clienteService.findPage(page, linesPerPage, orderBy,direction);
		Page<ClienteDTO> listaDTO = lista.map(obj -> new ClienteDTO(obj));
		return ResponseEntity.ok().body(listaDTO);

	}
}
	
