package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Scanner scanner2 = new Scanner(System.in);
    private static Scanner scanner3 = new Scanner(System.in);
    private static Scanner scanner4 = new Scanner(System.in);
    private static Scanner scanner5 = new Scanner(System.in);

    private static Bank bank = new Bank();

    public static void main(String[] args) {
        boolean quit = false;
        int choice;
        while (!quit) {
            printInstructions();
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            if ((choice >= 0) && (choice <= 4)) {
                switch (choice) {
                    case 0:
                        newBranch();
                        break;
                    case 1:
                        addCustomer();
                        break;
                    case 2:
                        addTransaction();
                        break;
                    case 3:
                        PrintBranch();
                        break;
                    case 4:
                        quit = true;
                        break;
                }
            } else {
                System.out.println("Please enter a valid option");
            }
        }
    }


    private static void printInstructions() {
        System.out.println("\n\nRemy Bank");
        System.out.println("\nPress ");
        System.out.println("\t 0 - To create a new branch");
        System.out.println("\t 1 - To Add a new customer");
        System.out.println("\t 2 - To add a transaction");
        System.out.println("\t 3 - To print the branches, transactions of a customer or print a branch with customers");
        System.out.println("\t 4 - To quit");
    }


    private static void newBranch() {
        System.out.println("What is the name of the branch? \n");
        String tempBranchName = scanner2.nextLine();
        bank.addNewBranch(tempBranchName);
    }

    public static void addCustomer() {
        System.out.println("What is the name of the customer? \n");
        String tempCustName = scanner2.nextLine();
        System.out.println("Which branch do you want to add the customer? \n");
        bank.printBranches();
        int tempChoice = (scanner3.nextInt() - 1);
        String tempBranchName = bank.branches.get(tempChoice).getBranchName();
        System.out.println("Would you like to add a transaction as well?\n" +
                "Press 1 for Yes and press any other key for no");
        int tempChoice2 = scanner4.nextInt();
        if (tempChoice2 == 1) {
            System.out.println("How big do you want the transaction to be?");
            double tempTransaction = scanner5.nextDouble();
            bank.addCustomer(tempCustName, tempBranchName, tempTransaction);
        } else {
            bank.addCustomer(tempCustName, tempBranchName, 0);
        }
    }


    private static void addTransaction() {
        System.out.println("What is the name of the customer? \n");
        String tempName = scanner.nextLine();
        System.out.println("How big is the transaction you would like to add? \n");
        double tempTransaction = scanner2.nextDouble();
        bank.addTransaction(tempName, tempTransaction);
    }


    public static void PrintBranch() {
        System.out.println("Press 1, to print the branches, press 2 to print a branch with customers and press any other key to print a customer with the transactions");
        int tempChoice = scanner.nextInt();
        if (tempChoice == 1) {
            for (int i = 0; i < bank.branches.size(); i++) {
                System.out.println("branch: #" + (i + 1) + " " + bank.branches.get(i).getBranchName());
            }

        } else if (tempChoice == 2) {
            System.out.println("Which branch do you want to print? \n");
            for (int i = 0; i < bank.branches.size(); i++) {
                System.out.println("Press" + (i + 1) + "# for branch: " + bank.branches.get(i).getBranchName());
            }
            int tempBranchNumber = (scanner2.nextInt() - 1);
            bank.printCustomers(tempBranchNumber);
        } else {
            System.out.println("Which Customer do you want to want to print?");
            String tempName = scanner3.nextLine();
            bank.printCustomerTransactions(tempName);
        }
    }
}

//renaming branches, deleting and setting transactions/branchnames