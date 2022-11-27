package com.razzolim.batch.writer.jdbc.writer;

import com.razzolim.batch.writer.jdbc.domain.Conta;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class ClienteInvalidoWriterConfig {

    @Bean
    public FlatFileItemWriter<Conta> clienteInvalidoWriter() {
        return new FlatFileItemWriterBuilder<Conta>()
                .name("clienteInvalidoWriter")
                .resource(new FileSystemResource("./src/main/resources/files/writer/jdbc/composite/error/clientes-invalidos.txt"))
                .delimited()
                .names("clienteId")
                .build();
    }

}
