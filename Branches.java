package com.company;

import java.util.ArrayList;

public class Branches {

    String branchName;
    ArrayList<Customers> customers = new ArrayList();

    public Branches(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchName() {
        return branchName;
    }

    public ArrayList<Customers> getCustomers() {
        return customers;
    }

}
