package br.com.eberts.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eberts.domain.Categoria;
import br.com.eberts.services.CategoriaService;

@RestController
@RequestMapping(value = "categorias")
public class CategoriaResource {
	
	private final CategoriaService categoriaService;
	
	public CategoriaResource (CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findOne(@PathVariable Integer id) {
		
		Categoria cat = categoriaService.findById(id);
		return ResponseEntity.ok(cat);
	}
	
	@GetMapping
	public List<Categoria> findAll() {
		
		return categoriaService.findAll();

	}
	

}
