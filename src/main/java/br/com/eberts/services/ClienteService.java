package br.com.eberts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.eberts.domain.Cliente;
import br.com.eberts.repositories.ClienteRepository;
import br.com.eberts.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	private final ClienteRepository clienteRepository;
	
	public ClienteService (ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public Cliente findById (Integer id) {
		Optional<Cliente> cli  = clienteRepository.findById(id);
		return cli.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado com id: " + id + ", do tipo: " + Cliente.class.getName()));
	}
	
	public List<Cliente> findAll() {
		
		return clienteRepository.findAll();
	}
	
	
}
