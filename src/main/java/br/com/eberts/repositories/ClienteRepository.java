package br.com.eberts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eberts.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
