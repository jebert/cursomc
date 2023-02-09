package br.com.eberts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eberts.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
