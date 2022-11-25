package com.razzolim.batch.reader.delimitedfile.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class DelimitedFileJobConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job delimitedFileJob(Step readerDelimitedFileStep) {
        return jobBuilderFactory
                .get("delimitedFileJob")
                .start(readerDelimitedFileStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }
}
