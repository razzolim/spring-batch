package com.razzolim.batch.processor.script.reader;

import com.razzolim.batch.processor.script.domain.Cliente;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ProcessorScriptReaderConfig {
	@StepScope
	@Bean
	public FlatFileItemReader<Cliente> processorScriptReader(
			@Value("#{jobParameters['clientFile']}") Resource resource) {
		return new FlatFileItemReaderBuilder<Cliente>()
				.name("processorScriptReader")
				.resource(resource)
				.delimited()
				.names("nome", "idade", "email")
				.targetType(Cliente.class)
				.build();
	}
}
