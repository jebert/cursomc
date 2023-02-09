package br.com.eberts.domain;

import java.io.Serializable;
import java.util.Date;

import br.com.eberts.domain.enums.EstadoPagamento;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class PagamentoComCartao extends Pagamento implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer numeroDeParcelas;


	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}

}
