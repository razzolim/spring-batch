package com.razzolim.batch.reader.multipleformat.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultipleFormatsFileWriterConfig {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    public ItemWriter readMultipleFormatsFileWriter() {
        return items -> items.forEach(System.out::println);
    }

}
