package com.razzolim.batch.processor.script.step;

import com.razzolim.batch.processor.script.domain.Cliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessorScriptStepConfig {
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step processorScriptStep(
			ItemReader<Cliente> processorScriptReader,
			ItemProcessor<Cliente, Cliente> processorScriptProcessor,
			ItemWriter<Cliente> processorScriptWriter) {
		return stepBuilderFactory
				.get("processorScriptStep")
				.<Cliente, Cliente>chunk(1)
				.reader(processorScriptReader)
				.processor(processorScriptProcessor)
				.writer(processorScriptWriter)
				.build();
	}
}
