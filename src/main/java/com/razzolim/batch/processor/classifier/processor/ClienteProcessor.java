package com.razzolim.batch.processor.classifier.processor;

import com.razzolim.batch.processor.classifier.domain.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class ClienteProcessor implements ItemProcessor<Cliente, Cliente> {

    private static final Logger LOGGER = LoggerFactory.getLogger(Cliente.class);

    @Override
    public Cliente process(Cliente cliente) throws Exception {
        LOGGER.error("Aplicando regras de negócio no cliente {}", cliente.getEmail());
        return cliente;
    }
}
