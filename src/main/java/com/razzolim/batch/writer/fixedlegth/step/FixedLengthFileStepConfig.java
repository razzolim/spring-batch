package com.razzolim.batch.writer.fixedlegth.step;

import com.razzolim.batch.writer.fixedlegth.domain.Cliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FixedLengthFileStepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step readFixedLengthFileStep(ItemReader<Cliente> reader, ItemWriter<Cliente> writer) {
        return stepBuilderFactory
                .get("readFixedLengthFileStep")
                .<Cliente, Cliente>chunk(1)
                .reader(reader)
                .writer(writer)
                .build();
    }

}
