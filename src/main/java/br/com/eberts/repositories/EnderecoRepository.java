package br.com.eberts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eberts.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
