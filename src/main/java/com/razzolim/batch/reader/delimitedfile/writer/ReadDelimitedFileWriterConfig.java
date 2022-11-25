package com.razzolim.batch.reader.delimitedfile.writer;

import com.razzolim.batch.reader.delimitedfile.domain.Client;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReadDelimitedFileWriterConfig {

    @Bean
    public ItemWriter<Client> readDelimitedFileWriter() {
        return items -> items.forEach(System.out::println);
    }
}
