package com.razzolim.batch.writer.jdbc.processor;

import com.razzolim.batch.writer.jdbc.domain.Cliente;
import com.razzolim.batch.writer.jdbc.domain.Conta;
import com.razzolim.batch.writer.jdbc.domain.TipoConta;
import org.springframework.batch.item.ItemProcessor;

public class ContaDiamanteItemProcessor implements ItemProcessor<Cliente, Conta> {

	@Override
	public Conta process(Cliente cliente) throws Exception {
		Conta conta = new Conta();
		conta.setClienteId(cliente.getEmail());
		conta.setTipo(TipoConta.DIAMANTE);
		conta.setLimite(5000.0);
		return conta;
	}
	
}
