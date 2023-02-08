package br.com.eberts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eberts.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
