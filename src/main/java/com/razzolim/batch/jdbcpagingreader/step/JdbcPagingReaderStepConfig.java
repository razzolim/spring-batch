package com.razzolim.batch.jdbcpagingreader.step;

import com.razzolim.batch.jdbcpagingreader.domain.Cliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JdbcPagingReaderStepConfig {
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step jdbcPagingReaderStep(ItemReader<Cliente> jdbcPagingReader, ItemWriter<Cliente> jdbcPagingWriter) {
		return stepBuilderFactory
				.get("jdbcPagingReaderStep")
				.<Cliente, Cliente>chunk(1)
				.reader(jdbcPagingReader)
				.writer(jdbcPagingWriter)
				.build();
	}
}
