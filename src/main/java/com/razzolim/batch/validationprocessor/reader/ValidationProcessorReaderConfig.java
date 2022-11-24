package com.razzolim.batch.validationprocessor.reader;

import com.razzolim.batch.validationprocessor.domain.Cliente;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ValidationProcessorReaderConfig {
	@StepScope
	@Bean
	public FlatFileItemReader<Cliente> validationProcessorReader(
			@Value("#{jobParameters['clientFile']}") Resource arquivoClientes) {
		return new FlatFileItemReaderBuilder<Cliente>()
				.name("validationProcessorReader")
				.resource(arquivoClientes)
				.delimited()
				.names("nome", "idade", "email")
				.targetType(Cliente.class)
				.build();
	}
}
