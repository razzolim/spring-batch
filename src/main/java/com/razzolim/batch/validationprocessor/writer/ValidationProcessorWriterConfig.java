package com.razzolim.batch.validationprocessor.writer;

import com.razzolim.batch.validationprocessor.domain.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidationProcessorWriterConfig {
	@Bean
	public ItemWriter<Cliente> processadorValidacaoWriter() {
		return clientes -> clientes.forEach(System.out::println);
	}
}
