package com.razzolim.batch.reader.skipexception.writer;

import com.razzolim.batch.reader.skipexception.domain.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SkipExceptionWriterConfig {
	@Bean
	public ItemWriter<Cliente> printWriter() {
		return clientes -> clientes.forEach(System.out::println);
	}
}
