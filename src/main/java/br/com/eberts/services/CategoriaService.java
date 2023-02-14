package br.com.eberts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.eberts.domain.Categoria;
import br.com.eberts.dto.CategoriaDTO;
import br.com.eberts.repositories.CategoriaRepository;
import br.com.eberts.services.exceptions.DataIntegrityException;
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

	public Categoria save(Categoria cat) {
		cat.setId(null);
		return categoriaRepository.save(cat);
	}

	public Categoria update(Categoria cat) {
		findById(cat.getId());
		return categoriaRepository.save(cat);
	}

	public void DeleteById(Integer id) {
		findById(id);
		try {
			categoriaRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos.");
		}
	}
	
	public List<Categoria> findAll() {
		
		return categoriaRepository.findAll();
	}
	
	public Page<Categoria> findPage (Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return categoriaRepository.findAll(pageRequest);
	}

	public Categoria fromDto(CategoriaDTO catDto) {
		return new Categoria(catDto.getId(), catDto.getNome());
	}
	
	
}
