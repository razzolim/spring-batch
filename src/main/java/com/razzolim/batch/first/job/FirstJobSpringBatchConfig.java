package com.razzolim.batch.first.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class FirstJobSpringBatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job printsHelloJob(Step printsHelloStep) {
        return jobBuilderFactory
                .get("printsHelloJob")
                .start(printsHelloStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }

}
