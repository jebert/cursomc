package br.com.eberts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eberts.domain.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
