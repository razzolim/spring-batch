package com.razzolim.batch.writer.delimitedfile.reader;

import com.razzolim.batch.writer.delimitedfile.domain.Cliente;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class DelimitedFileReaderConfig {

    @Bean
    @StepScope
    public FlatFileItemReader<Cliente> readerDelimitedFile(
            @Value("#{jobParameters['clientFile']}") Resource resource) {
        return new FlatFileItemReaderBuilder<Cliente>()
                .name("readerDelimitedFile")
                .resource(resource)
                .delimited()
                .names("nome", "sobrenome", "idade", "email")
                .targetType(Cliente.class)
                .build();
    }

}
