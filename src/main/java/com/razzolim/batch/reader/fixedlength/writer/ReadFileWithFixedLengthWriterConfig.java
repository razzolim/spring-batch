package com.razzolim.batch.reader.fixedlength.writer;

import com.razzolim.batch.reader.fixedlength.domain.Client;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReadFileWithFixedLengthWriterConfig {

    @Bean
    public ItemWriter<Client> readFileWithFixedLengthWriter() {
        return items -> items.forEach(System.out::println);
    }

}
