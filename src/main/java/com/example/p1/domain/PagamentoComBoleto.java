package com.example.p1.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.example.p1.domain.enums.EstadoPagamento;


@Entity
public class PagamentoComBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	
	private Date dataVencimento;
	private Date datapagamento;
	
	public PagamentoComBoleto() {
		
	}
	
	public PagamentoComBoleto(EstadoPagamento pendente, Pedido ped2, Date date) {
		
	}

	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);
		this.setDataVencimento(dataVencimento);
		this.setDatapagamento(dataPagamento);
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDatapagamento() {
		return datapagamento;
	}

	public void setDatapagamento(Date datapagamento) {
		this.datapagamento = datapagamento;
	}

}
