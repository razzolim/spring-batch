package com.razzolim.batch.fixedlength.step;

import com.razzolim.batch.fixedlength.domain.Client;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReadFileWithFixedLengthStepConfig {

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step readFileWithFixedLength(ItemReader<Client> readFileWithFixedLengthReader,
                                        ItemWriter<Client> readFileWithFixedLengthWriter) {
        return stepBuilderFactory
                .get("readFileWithFixedLength")
                .<Client, Client>chunk(1)
                .reader(readFileWithFixedLengthReader)
                .writer(readFileWithFixedLengthWriter)
                .build();
    }

}
