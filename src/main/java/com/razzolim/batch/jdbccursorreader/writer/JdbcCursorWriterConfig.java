package com.razzolim.batch.jdbccursorreader.writer;

import com.razzolim.batch.jdbccursorreader.domain.Cliente;
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