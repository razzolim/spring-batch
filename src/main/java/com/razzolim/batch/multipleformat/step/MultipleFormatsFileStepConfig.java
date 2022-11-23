package com.razzolim.batch.multipleformat.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultipleFormatsFileStepConfig {

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step readMultipleFormatsFileStep(
            FlatFileItemReader readMultipleFormatsFileReader,
            ItemWriter readMultipleFormatsFileWriter) {
        return stepBuilderFactory
                .get("readMultipleFormatsFileStep")
                .chunk(1)
                .reader(readMultipleFormatsFileReader)
                .writer(readMultipleFormatsFileWriter)
                .build();
    }


}
