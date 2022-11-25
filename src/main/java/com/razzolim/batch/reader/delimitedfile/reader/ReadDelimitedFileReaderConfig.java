package com.razzolim.batch.reader.delimitedfile.reader;

import com.razzolim.batch.reader.delimitedfile.domain.Client;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ReadDelimitedFileReaderConfig {

    @Bean
    @StepScope
    public FlatFileItemReader<Client> readDelimitedFileReader(
            @Value("#{jobParameters['clientFile']}") Resource resource
            ) {
        return new FlatFileItemReaderBuilder<Client>()
                .name("readDelimitedFileReader")
                .resource(resource)
                .delimited()
                .names("firstName", "lastName", "age", "email")
                .targetType(Client.class)
                .build();
    }

}
