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
public class PagamentoComBoleto extends Pagamento implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Date dataVencimento;
	private Date dataPagamento;
	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}
	
	

}
