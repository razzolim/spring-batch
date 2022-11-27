package com.razzolim.batch.writer.jdbc.processor;

import com.razzolim.batch.writer.jdbc.domain.Conta;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.classify.Classifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClassifierContaWriterConfig {

    @Bean
    public ClassifierCompositeItemWriter<Conta> classifierContaWriter(
            @Qualifier("clienteInvalidoWriter")FlatFileItemWriter<Conta> invalidWriter,
            CompositeItemWriter<Conta> validWriter) {
        return new ClassifierCompositeItemWriterBuilder<Conta>()
                .classifier(classifier(invalidWriter, validWriter))
                .build();
    }

    private Classifier<Conta, ItemWriter<? super Conta>> classifier(FlatFileItemWriter<Conta> invalidWriter,
                                                                    CompositeItemWriter<Conta> validWriter) {
        return conta -> {
            if (conta.getTipo() != null) {
                return validWriter;
            }
            return invalidWriter;
        };
    }

}
