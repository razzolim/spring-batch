package com.razzolim.batch.writer.jdbc.writer;

import com.razzolim.batch.writer.jdbc.domain.Conta;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class FileContaWriterConfig {

    @Bean
    public FlatFileItemWriter<Conta> fileContaWriter() {
        return new FlatFileItemWriterBuilder<Conta>()
                .name("fileContaWriter")
                .resource(new FileSystemResource("./src/main/resources/files/writer/jdbc/composite/contas.txt"))
                .delimited()
                .names("tipo", "limite", "clienteId")
                .build();
    }


}
