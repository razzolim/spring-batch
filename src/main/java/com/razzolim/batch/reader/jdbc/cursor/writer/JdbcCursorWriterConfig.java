package com.razzolim.batch.reader.jdbc.cursor.writer;

import com.razzolim.batch.reader.jdbc.cursor.domain.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JdbcCursorWriterConfig {
    @Bean
    public ItemWriter<Cliente> jdbcCursorWriter() {
        return clients -> clients.forEach(System.out::println);
    }
}