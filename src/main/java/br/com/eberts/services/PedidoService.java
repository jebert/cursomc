package br.com.eberts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.eberts.domain.Pedido;
import br.com.eberts.repositories.PedidoRepository;
import br.com.eberts.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	private final PedidoRepository pedidoRepository;
	
	public PedidoService (PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}

	public Pedido findById (Integer id) {
		Optional<Pedido> cat = pedidoRepository.findById(id);
		return cat.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado com id: " + id + ", do tipo: " + Pedido.class.getName()));
	}
	
	public List<Pedido> findAll() {
		
		return pedidoRepository.findAll();
	}
	
	
}
