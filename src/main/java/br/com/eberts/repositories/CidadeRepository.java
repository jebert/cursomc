package br.com.eberts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eberts.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
