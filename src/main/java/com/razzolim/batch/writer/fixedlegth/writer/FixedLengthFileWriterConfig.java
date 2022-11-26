package com.razzolim.batch.writer.fixedlegth.writer;

import com.razzolim.batch.writer.fixedlegth.domain.Cliente;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class FixedLengthFileWriterConfig {

    @StepScope
    @Bean
    public FlatFileItemWriter<Cliente> writerFixedLengthFileWriter(
            @Value("#{jobParameters['clientOutput']}") Resource output) {
        return new FlatFileItemWriterBuilder<Cliente>()
                .name("writerFixedLengthFileWriter")
                .resource(output)
                .formatted()
                .format("%-9s %-9s %-2s %-19s")
                .names("nome", "sobrenome", "idade", "email")
                .build();
    }

}
