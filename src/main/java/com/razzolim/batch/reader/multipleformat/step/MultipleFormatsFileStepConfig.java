package com.razzolim.batch.reader.multipleformat.step;

import com.razzolim.batch.reader.multipleformat.reader.FileClientTransactionReader;
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
                //.reader(readMultipleFormatsFileReader)
                .reader(new FileClientTransactionReader(readMultipleFormatsFileReader))
                .writer(readMultipleFormatsFileWriter)
                .build();
    }


}
