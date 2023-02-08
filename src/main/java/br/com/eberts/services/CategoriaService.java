package br.com.eberts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.eberts.domain.Categoria;
import br.com.eberts.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	private final CategoriaRepository categoriaRepository;
	
	public CategoriaService (CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	public Categoria findById (Integer id) {
		Optional<Categoria> cat = categoriaRepository.findById(id);
		return cat.orElse(null);
	}

	public List<Categoria> findAll() {
		
		return categoriaRepository.findAll();
	}
	
	
}
