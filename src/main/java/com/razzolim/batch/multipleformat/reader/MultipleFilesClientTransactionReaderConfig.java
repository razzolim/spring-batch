package com.razzolim.batch.multipleformat.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class MultipleFilesClientTransactionReaderConfig {

    @SuppressWarnings({"rawtypes", "unchecked"})
    public MultiResourceItemReader multipleFilesClientTransactionReader(
            @Value("#{jobParameters['clientFiles']}")Resource[] resources,
            FlatFileItemReader readMultipleFormatsFileReader) {
        return new MultiResourceItemReaderBuilder<>()
                .name("multipleFilesClientTransactionReader")
                .resources(resources)
                .delegate(new FileClientTransactionReader(readMultipleFormatsFileReader))
                .build();
    }
}
