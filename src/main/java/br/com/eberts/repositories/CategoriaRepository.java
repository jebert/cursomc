package br.com.eberts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eberts.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
