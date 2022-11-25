package com.razzolim.batch.processor.classifier.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessadorClassifierWriterConfig {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public ItemWriter processadorClassifierWriter() {
		return items -> items.forEach(System.out::println);
	}
}
