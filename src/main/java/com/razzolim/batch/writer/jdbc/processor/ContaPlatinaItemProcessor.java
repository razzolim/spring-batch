package com.razzolim.batch.writer.jdbc.processor;

import com.razzolim.batch.writer.jdbc.domain.Cliente;
import com.razzolim.batch.writer.jdbc.domain.Conta;
import com.razzolim.batch.writer.jdbc.domain.TipoConta;
import org.springframework.batch.item.ItemProcessor;

public class ContaPlatinaItemProcessor implements ItemProcessor<Cliente, Conta> {

	@Override
	public Conta process(Cliente cliente) throws Exception {
		Conta conta = new Conta();
		conta.setClienteId(cliente.getEmail());
		conta.setTipo(TipoConta.PLATINA);
		conta.setLimite(2500.0);
		return conta;
	}

}
