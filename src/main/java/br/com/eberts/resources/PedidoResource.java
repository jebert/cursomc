package br.com.eberts.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eberts.domain.Pedido;
import br.com.eberts.services.PedidoService;

@RestController
@RequestMapping(value = "pedidos")
public class PedidoResource {
	
	private final PedidoService pedidoService;
	
	public PedidoResource (PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findOne(@PathVariable Integer id) {
		
		Pedido cli  = pedidoService.findById(id);
		return ResponseEntity.ok(cli);
	}
	
	@GetMapping
	public List<Pedido> findAll() {
		
		return pedidoService.findAll();

	}
	

}
