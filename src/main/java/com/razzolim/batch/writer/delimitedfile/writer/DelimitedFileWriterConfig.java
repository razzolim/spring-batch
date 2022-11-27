package com.razzolim.batch.writer.delimitedfile.writer;

import com.razzolim.batch.writer.delimitedfile.domain.Cliente;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class DelimitedFileWriterConfig {

    @Bean
    @StepScope
    public FlatFileItemWriter<Cliente> delimitedFileWriter(
            @Value("#{jobParameters['clientOutput']}") Resource output) {
        return new FlatFileItemWriterBuilder<Cliente>()
                .name("delimitedFileWriter")
                .resource(output)
                .delimited()
                .names("nome", "sobrenome", "idade", "email")
                .build();
    }

}
