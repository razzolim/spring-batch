package com.razzolim.batch.processorscript.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class ProcessorScriptJobConfig {
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Bean
	public Job processorScriptJob(Step processorScriptStep) {
		return jobBuilderFactory
				.get("processorScriptJob")
				.start(processorScriptStep)
				.incrementer(new RunIdIncrementer())
				.build();
	}
}
