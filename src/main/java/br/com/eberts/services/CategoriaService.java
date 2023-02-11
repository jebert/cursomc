package br.com.eberts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.eberts.domain.Categoria;
import br.com.eberts.repositories.CategoriaRepository;
import br.com.eberts.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	private final CategoriaRepository categoriaRepository;
	
	public CategoriaService (CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	public Categoria findById (Integer id) {
		Optional<Categoria> cat = categoriaRepository.findById(id);
		return cat.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado com id: " + id + ", do tipo: " + Categoria.class.getName()));
	}
	
	public List<Categoria> findAll() {
		
		return categoriaRepository.findAll();
	}

	public Categoria save(Categoria cat) {
		cat.setId(null);
		return categoriaRepository.save(cat);
	}

	public Categoria update(Categoria cat) {
		findById(cat.getId());
		return categoriaRepository.save(cat);
	}
	
	
}
