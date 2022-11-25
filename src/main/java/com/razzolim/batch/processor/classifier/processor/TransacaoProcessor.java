package com.razzolim.batch.processor.classifier.processor;

import com.razzolim.batch.processor.classifier.domain.Transacao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class TransacaoProcessor implements ItemProcessor<Transacao, Transacao> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransacaoProcessor.class);

    @Override
    public Transacao process(Transacao trx) throws Exception {
        LOGGER.error("Aplicando regras de negócio na transação {}", trx.getId());
        return trx;
    }
}
