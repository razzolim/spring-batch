package com.razzolim.batch.writer.jdbc.processor;

import com.razzolim.batch.writer.jdbc.domain.Cliente;
import com.razzolim.batch.writer.jdbc.domain.Conta;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemProcessorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeracaoContaProcessorConfig {
	@Bean
	public ItemProcessor<Cliente, Conta> geracaoContaProcessor() {
		return new ClassifierCompositeItemProcessorBuilder<Cliente, Conta>()
				.classifier(new GeracaoContaClassifier())
				.build();
	}
}
