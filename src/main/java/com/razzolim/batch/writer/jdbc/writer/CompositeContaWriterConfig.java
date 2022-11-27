package com.razzolim.batch.writer.jdbc.writer;

import com.razzolim.batch.writer.jdbc.domain.Conta;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.batch.item.support.builder.CompositeItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompositeContaWriterConfig {

    @Bean
    public CompositeItemWriter<Conta> compositeContaWriter(
            FlatFileItemWriter<Conta> fileWriter,
            JdbcBatchItemWriter<Conta> jdbcWriter) {
        return new CompositeItemWriterBuilder<Conta>()
                .delegates(fileWriter, jdbcWriter)
                .build();
    }

}
