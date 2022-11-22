package com.razzolim.batch.oddeven;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableBatchProcessing
public class OddEvenBatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job printsOddEvenJob() {
        return jobBuilderFactory
                .get("printsOddEvenJob")
                .start(printsOddEvenStep())
                .incrementer(new RunIdIncrementer())
                .build();
    }

    public Step printsOddEvenStep() {
        return stepBuilderFactory
                .get("printsOddEvenStep")
                .<Integer, String>chunk(1)
                .reader(countUntilTenReader())
                .processor(oddOrEvenProcessor())
                .writer(printsWriter())
                .build();
    }

    private IteratorItemReader<Integer> countUntilTenReader() {
        List<Integer> numbersOneToTen = Arrays.asList(1, 2, 3, 4, 5, 6, 7,8, 9, 10);
        return new IteratorItemReader<>(numbersOneToTen);
    }

    private FunctionItemProcessor<Integer, String> oddOrEvenProcessor() {
        return new FunctionItemProcessor<>(
                item -> item % 2 == 0 ? String.format("Item %s is odd", item) : String.format("Item %s is even", item)
        );
    }

    private ItemWriter<String> printsWriter() {
        return items -> items.forEach(System.out::println);
    }

}
