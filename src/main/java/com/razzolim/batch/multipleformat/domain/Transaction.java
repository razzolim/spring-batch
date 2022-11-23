package com.razzolim.batch.multipleformat.domain;

public class Transaction {

    private String id;
    private String description;
    private Double amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("Transaction{id=%s, description=%s, amount=%s}", id, description, amount);
    }
}
