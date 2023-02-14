package br.com.eberts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.eberts.domain.Cliente;
import br.com.eberts.dto.ClienteDTO;
import br.com.eberts.domain.Cliente;
import br.com.eberts.repositories.ClienteRepository;
import br.com.eberts.services.exceptions.DataIntegrityException;
import br.com.eberts.services.exceptions.ObjectNotFoundException;
import jakarta.validation.Valid;

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

	public Cliente update(Cliente obj) {
		Cliente newObj = findById(obj.getId());
		updateData(newObj, obj);
		return clienteRepository.save(newObj);
	}

	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
		
	}

	public void DeleteById(Integer id) {
		findById(id);
		try {
			clienteRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma cliente que possui pedidos.");
		}
	}
	
	public List<Cliente> findAll() {
		
		return clienteRepository.findAll();
	}
	
	public Page<Cliente> findPage (Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return clienteRepository.findAll(pageRequest);
	}

	public Cliente fromDto(ClienteDTO cliDto) {
		
		return new Cliente(cliDto.getId(), cliDto.getNome(), cliDto.getEmail(), null, null);
	}

}
