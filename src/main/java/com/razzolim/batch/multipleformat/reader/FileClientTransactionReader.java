package com.razzolim.batch.multipleformat.reader;

import com.razzolim.batch.multipleformat.domain.Client;
import com.razzolim.batch.multipleformat.domain.Transaction;
import org.springframework.batch.item.*;

public class FileClientTransactionReader implements ItemStreamReader<Client> {

    private Object actualObject;
    private ItemStreamReader<Object> delegate;

    public FileClientTransactionReader(ItemStreamReader<Object> delegate) {
        this.delegate = delegate;
    }

    @Override
    public Client read() throws Exception {
        if (actualObject == null) {
            actualObject = delegate.read();
        }

        Client client = (Client) actualObject;
        actualObject = null;

        if (client != null) {
            while (peek() instanceof Transaction) {
                client.getTransactions().add((Transaction) actualObject);
            }
        }
        return client;
    }

    private Object peek() throws Exception {
        actualObject = delegate.read();
        return actualObject;
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        delegate.open(executionContext);
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        delegate.update(executionContext);
    }

    @Override
    public void close() throws ItemStreamException {
        delegate.close();
    }
}
