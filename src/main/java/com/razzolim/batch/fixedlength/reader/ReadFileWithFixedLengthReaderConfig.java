package com.razzolim.batch.fixedlength.reader;

import com.razzolim.batch.fixedlength.domain.Client;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ReadFileWithFixedLengthReaderConfig {

    @StepScope
    @Bean
    public FlatFileItemReader<Client> readerFileWithFixedLengthReader(
            @Value("#{jobParameters['clientFile']}") Resource clientFile
    ) {
        return new FlatFileItemReaderBuilder<Client>()
                .name("readerFileWithFixedLengthReader")
                .resource(clientFile)
                .fixedLength()
                .columns(new Range[]{new Range(1, 10), new Range(11, 20), new Range(21, 23), new Range(24, 43)})
                .names("firstName", "lastName", "age", "email")
                .targetType(Client.class)
                .build();
    }

}
