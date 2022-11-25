package com.razzolim.batch.reader.skipexception.reader;

import javax.sql.DataSource;

import com.razzolim.batch.reader.skipexception.domain.Cliente;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Configuration
public class SkipExceptionReaderConfig {
	@Bean
	public ItemReader<Cliente> skipExceptionReader(@Qualifier("appDataSource") DataSource dataSource) {
		return new JdbcCursorItemReaderBuilder<Cliente>()
				.name("skipExceptionReader")
				.dataSource(dataSource)
				.sql("select * from cliente")
				.rowMapper(rowMapper())
				.build();
	}

	private RowMapper<Cliente> rowMapper() {
		return new RowMapper<Cliente>() {
			@Override
			public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
				if (rs.getRow() == 11) {
					throw new SQLException(String.format("Finishing execution - Invalid client: %s", rs.getString("email")));
				}
				return clientRowMapper(rs);
			}

			private Cliente clientRowMapper(ResultSet rs) throws SQLException {
				Cliente client = new Cliente();
				client.setNome(rs.getString("nome"));
				client.setSobrenome(rs.getString("sobrenome"));
				client.setIdade(rs.getString("idade"));
				client.setEmail(rs.getString("email"));
				return client;
			}
		};
	}
}
