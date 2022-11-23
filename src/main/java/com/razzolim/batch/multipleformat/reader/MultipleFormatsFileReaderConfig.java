package com.razzolim.batch.multipleformat.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class MultipleFormatsFileReaderConfig {

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean
    @StepScope
    public FlatFileItemReader multipleFormatsFileItemReader(
            @Value("#{jobParameters['clientFile']}") Resource resource,
            LineMapper lineMapper) {
        return new FlatFileItemReaderBuilder()
                .name("multipleFormatsFileItemReader")
                .resource(resource)
                .lineMapper(lineMapper)
                .build();
    }

}
