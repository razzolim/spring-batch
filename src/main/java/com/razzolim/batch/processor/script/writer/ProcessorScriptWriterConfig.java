package com.razzolim.batch.processor.script.writer;

import com.razzolim.batch.processor.script.domain.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessorScriptWriterConfig {
	@Bean
	public ItemWriter<Cliente> processorScriptWriter() {
		return clientes -> clientes.forEach(System.out::println);
	}
}
