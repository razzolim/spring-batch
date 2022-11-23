package com.razzolim.batch.multipleformat.domain;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private String firstName;
    private String lastName;
    private String age;
    private String email;
    private List<Transaction> transactions = new ArrayList<>();

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("Client{firstName=%s, lastName=%s, age=%s, email=%s, transactions=%s}",
                firstName, lastName, age, email, transactions.isEmpty() ? "" : transactions);
    }

}
