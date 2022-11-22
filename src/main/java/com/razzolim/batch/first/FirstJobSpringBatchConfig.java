package com.razzolim.batch.first;

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

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job printsHelloJob() {
        return jobBuilderFactory
                .get("printsHelloJob")
                .start(printsHelloStep())
                .incrementer(new RunIdIncrementer())
                .build();
    }

    public Step printsHelloStep() {
        return stepBuilderFactory
                .get("printsHelloStep")
                .tasklet(printsHelloName(null))
                .build();
    }

    @Bean
    @StepScope
    public Tasklet printsHelloName(@Value("#{jobParameters['name']}") String name) {
        return (contribution, chunkContext) -> {
            System.out.printf("Hello, %s!%n", name);
            return RepeatStatus.FINISHED;
        };
    }

}
