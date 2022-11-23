package com.razzolim.batch.delimitedfile.step;

import com.razzolim.batch.delimitedfile.domain.Client;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReadDelimitedFileStepConfig {

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step readDelimitedFileStep(
            ItemReader<Client> readDelimitedFileReader,
            ItemWriter<Client> readDelimitedFileWriter) {
        return stepBuilderFactory
                .get("readDelimitedFileStep")
                .<Client, Client>chunk(1)
                .reader(readDelimitedFileReader)
                .writer(readDelimitedFileWriter)
                .build();
    }

}
