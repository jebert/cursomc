package br.com.eberts.resources;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<?> save (@RequestBody Categoria cat){
		cat = categoriaService.save(cat);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cat.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@RequestBody Categoria cat,@PathVariable Integer id) {
		cat.setId(id);
		cat = categoriaService.update(cat);
		return ResponseEntity.noContent().build();
		
	}
}
