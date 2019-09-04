package org.kemetkoder.astevens;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    Scanner userInput = new Scanner(System.in);
    private Branch bankBranch = new Branch();
    private ArrayList<Branch> branchList = new ArrayList<Branch>();

    public Bank(){
        branchList.add(this.getBankBranch());
    }

    public Branch getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(Branch bankBranch) {
        this.bankBranch = bankBranch;
    }

    public ArrayList<Branch> getBranchList() {
        return branchList;
    }

    public Branch createBranch(String name, String region){

        // NOTE: Don't expose a private variable (i.e. - bankBranch) in a public method;
        // Use the public getters and setters to modify the private
        // variable
        this.setBankBranch(new Branch(name, region));
        branchList.add(this.getBankBranch());
        return this.getBankBranch();
    }

    public void displayCustomers(Branch bnkBranch){
        ArrayList<Customer> customerList = bnkBranch.getCustomerList();

        if(!customerList.isEmpty())
            for(Customer bankCustomer : customerList)
                System.out.println("ID: " + (customerList.indexOf(bankCustomer)+1) +
                        " - " + bankCustomer.displayCustomerInfo());
        else
            System.out.println("There are no customers for " +
                    bnkBranch.getBranchName());
    }

    /**
     * Returns the branch with the updated customer information
     * @param bankBranch
     * @return
     */
    public Branch processNewCustomer(Branch bankBranch){
        this.setBankBranch(bankBranch);
        bankBranch.addNewCustomer();        // NOTE: Method takes care of creating a new customer

        return this.getBankBranch();
    }

    public void processCustomerTransaction(){
        int custID;
        Transaction xAction = new Transaction();

        // TODO: List the customers for the branch
        System.out.println("Please select the customer for the transaction:");
        this.displayCustomers(this.getBankBranch());

        // TODO: Select the customer for the transaction
        System.out.println("Enter the customer ID here: ");
        custID = userInput.nextInt();
        userInput.nextLine();       // Capture extraneous newline character

        // TODO: Convert index into Customer
        Customer branchCustomer;
        ArrayList<Customer> branchCustomers = getBankBranch().getCustomerList();
        branchCustomer = branchCustomers.get(custID-1);     // NOTE: the customer index is one less than the custID

        // TODO: List the transactions to perform
        System.out.println("\nPlease select from the following transactions:");
        xAction.transactionMenu();

        // TODO: Select the desired transaction
        char xActionSelection = userInput.nextLine().charAt(0);

        // TODO: Perform transaction
        performTransaction(xActionSelection, xAction, branchCustomer);

        // TODO: Display customer's current balance after the transaction
        System.out.println(branchCustomer.displayCustomerInfo());
    }

    private void performTransaction(char xActionSelection, Transaction xAction, Customer branchCustomer) {
        double transactionAmount;

        // Set selection to upper case to simplify switch() statement
        xActionSelection = Character.toUpperCase(xActionSelection);

        switch(xActionSelection){
            case 'D':
                System.out.println("Please enter the amount to deposit: ");
                transactionAmount = userInput.nextDouble();
                userInput.nextLine();       // Capture extraneous newline character
                xAction.performDeposit(branchCustomer, transactionAmount);
                break;
            case 'W':
                System.out.println("Please enter the amount to withdraw: ");
                transactionAmount = userInput.nextDouble();
                userInput.nextLine();       // Capture extraneous newline character
                xAction.performWithdrawl(branchCustomer, transactionAmount);
                break;
            default:
                System.out.println("ERROR: Invalid transaction.");
        }
    }
}
