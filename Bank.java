package com.company;

import java.util.ArrayList;

public class Bank {

    ArrayList<Branches> branches = new ArrayList<>();


    public void addNewBranch(String branchName) {
        int count = 0;
        for (int i = 0; i < branches.size(); i++) {
            if (branches.get(i).getBranchName().contains(branchName)) {
                System.out.println("Branch name already exists!");
                count++;
            }
        }
        if (count == 0) {
            branches.add(new Branches(branchName));
            System.out.println("Branch: " + branchName + " added!");
        }
    }

    public void addTransaction(String custName, Double transaction) {
        int count = 0;
        OUTER_LOOP:
        for (int i = 0; i < branches.size(); i++) {
            INNER_LOOP:
            for (int j = 0; j < branches.get(i).getCustomers().size(); i++) {
                if (branches.get(i).customers.get(j).getName().contains(custName)) {
                    branches.get(i).customers.get(j).transactions.add(transaction);
                    count++;
                }
            }
        }
        if (count == 0) {
            System.out.println("Customer not found!\nNo transaction added");
        }
    }

    public void addCustomer(String custName, String branchName, double transaction) {
        int count = 0;
        Customers tempCustomer;
        if (transaction == 0) {
            tempCustomer = new Customers(custName);
        } else {
            tempCustomer = new Customers(custName, transaction);
        }
        if (!CustomerCheck(tempCustomer)) {
            for (int i = 0; i < branches.size(); i++) {
                if (branches.get(i).getBranchName().contains(branchName)) {
                    branches.get(i).customers.add(tempCustomer);
                    System.out.println("Customer " + custName + " added!");
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("Branchname not found!");
            }
        } else {
            System.out.println("Customer already exists!");
        }
    }

    public boolean CustomerCheck(Customers tempCustomer) {
        OUTER_LOOP:
        for (int i = 0; i < branches.size(); i++) {
            INNER_LOOP:
            for (int j = 0; j < branches.get(i).getCustomers().size(); i++) {
                if (branches.get(i).customers.get(j) == tempCustomer) {
                    return true;
                }
            }
        }
        return false;
    }

    public void printCustomers(int branchNumber) {
        for (int i = 0; i < branches.get(branchNumber).getCustomers().size(); i++)
            System.out.println(branches.get(branchNumber).getCustomers().get(i).getName());
    }

    public void printCustomerTransactions(String customeName) {
        OUTER_LOOP:
        for (int i = 0; i < branches.size(); i++) {
            INNER_LOOP:
            for (int j = 0; j < branches.get(i).getCustomers().size(); j++)
                if (branches.get(i).getCustomers().get(j).getName().contains(customeName)) {
                    System.out.println(branches.get(i).getCustomers().get(j).getTransactions());
                }
        }
    }

    public void printBranches() {
        for (int i = 0; i < branches.size(); i++) {
            System.out.println("Press " + (i + 1) + "# for branch: " + branches.get(i).getBranchName());
        }
    }
}


