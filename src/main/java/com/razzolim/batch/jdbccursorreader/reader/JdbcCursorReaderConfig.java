package com.razzolim.batch.jdbccursorreader.reader;

import com.razzolim.batch.jdbccursorreader.domain.Cliente;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;

@Configuration
public class JdbcCursorReaderConfig {
    @Bean
    public JdbcCursorItemReader<Cliente> jdbcCursorReader(@Qualifier("appDataSource") DataSource ds) {
        return new JdbcCursorItemReaderBuilder<Cliente>()
                .name("jdbcCursorReader")
                .dataSource(ds)
                .sql("select * from cliente")
                .rowMapper(new BeanPropertyRowMapper<>(Cliente.class)) // it maps the columns, but the domain attr should have same name as defined in DB
                .build();
    }
}
