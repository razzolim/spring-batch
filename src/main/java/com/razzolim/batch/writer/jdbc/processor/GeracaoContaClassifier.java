package com.razzolim.batch.writer.jdbc.processor;

import com.razzolim.batch.writer.jdbc.domain.Cliente;
import com.razzolim.batch.writer.jdbc.domain.Conta;
import com.razzolim.batch.writer.jdbc.domain.TipoConta;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.classify.Classifier;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class GeracaoContaClassifier implements Classifier<Cliente, ItemProcessor<?, ? extends Conta>> {
	// Padrão de projeto para evitar o uso de if's no classificador.
	private static final Map<TipoConta, ItemProcessor<Cliente, Conta>> processadores = new HashMap<TipoConta, ItemProcessor<Cliente, Conta>>() {{
		put(TipoConta.PRATA, new ContaPrataItemProcessor());
		put(TipoConta.OURO, new ContaOuroItemProcessor());
		put(TipoConta.PLATINA, new ContaPlatinaItemProcessor());
		put(TipoConta.DIAMANTE, new ContaDiamanteItemProcessor());
	}};

	@Override
	public ItemProcessor<Cliente, Conta> classify(Cliente cliente) {
		TipoConta tipoConta = TipoConta.fromFaixaSalarial(cliente.getFaixaSalarial());
		return processadores.get(tipoConta);
	}

}
