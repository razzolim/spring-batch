package com.razzolim.batch.jdbcpagingreader.reader;

import com.razzolim.batch.jdbcpagingreader.domain.Cliente;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;

@Configuration
public class JdbcPagingReaderReaderConfig {
	@Bean
	public JdbcPagingItemReader<Cliente> jdbcPagingReader(@Qualifier("appDataSource") DataSource ds,
														  PagingQueryProvider queryProvider) {
		return new JdbcPagingItemReaderBuilder<Cliente>()
				.name("jdbcPagingReader")
				.dataSource(ds)
				.queryProvider(queryProvider)
				.pageSize(1)
				.rowMapper(new BeanPropertyRowMapper<>(Cliente.class))
				.build();
	}

	@Bean
	public SqlPagingQueryProviderFactoryBean queryProvider(@Qualifier("appDataSource") DataSource ds) {
		var queryProvider = new SqlPagingQueryProviderFactoryBean();
		queryProvider.setDataSource(ds);
		queryProvider.setSelectClause("select *");
		queryProvider.setFromClause("cliente");
		queryProvider.setSortKey("email");
		return queryProvider;
	}
}
