package com.company;

import java.util.ArrayList;

public class Customers {

    String name;
    ArrayList<Double> transactions;

    public Customers(String name, Double transaction) {
        this.name = name;
        transactions = new ArrayList<>();
        transactions.add(transaction);
    }

    public Customers(String name) {
        this.name = name;
        transactions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTransactions(ArrayList<Double> transactions) {
        this.transactions = transactions;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }
}
