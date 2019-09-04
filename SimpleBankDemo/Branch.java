package org.kemetkoder.astevens;

import java.util.*;

public class Branch {
    private String branchName;
    private String branchRegion;
    private ArrayList<Customer> customerList = new ArrayList<Customer>();

    public Branch(){
        this.branchName = "Kemet First National";
        this.branchRegion = "Upper Kemet";
    }

    public Branch(String name, String region){
        this.branchName = name;
        this.branchRegion = region;
    }

    public Branch(Customer cust){
        addNewCustomer(cust);
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchRegion() {
        return branchRegion;
    }

    public void setBranchRegion(String branchRegion) {
        this.branchRegion = branchRegion;
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    /**
     * Prompt user for customer information, create a new customer and add them to
     * the branch accounts list
     */
    public void addNewCustomer(){

        Customer bankCustomer = new Customer();

        // TODO: Add customer to branch accounts
        customerList.add(bankCustomer.createNewCustomer());
        System.out.println("Account for " + bankCustomer.getCustomerName() +
                " has been added to branch: " + this.getBranchName());

        // TEST...
//        System.out.println("TEST:");
//        for(Customer cust : this.getCustomerList())
//        	System.out.println("Customer: " + cust.getCustomerName());
    }

    /**
     * Add the customer that is passed into the Branch class
     * @param bankCustomer
     */
    public void addNewCustomer(Customer bankCustomer) {
        // TODO: Add customer to branch accounts
        customerList.add(bankCustomer);
        System.out.println("Account for " + bankCustomer.getCustomerName() +
                " has been added to this branch");
    }

}
