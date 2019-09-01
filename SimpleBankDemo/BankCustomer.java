package org.kemetkoder.astevens;

import java.util.*;

/**
 * The transactions will list deposits as positive doubles and withdrawls as negative doubles
 */
public class BankCustomer {
    private String customerName;
    private Double customerBalance;
    private ArrayList<Double> transactions = new ArrayList<Double>();

    public BankCustomer(){

    }

    /**
     * The amount added will be negative for withdrawls and positive for deposits
     * @param name
     * @param amount
     */
    public BankCustomer(String name, Double amount){
        this.setCustomerName(name);
        this.setCustomerBalance(amount);
        this.getTransactions().add(amount.doubleValue());
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public Double getCustomerBalance() {
        return customerBalance;
    }

    public void setCustomerBalance(Double customerBalance) {
        this.customerBalance = customerBalance;
    }

    public void displayCustomerTransactions(){
        if(!transactions.isEmpty()){
            for(Double amount : transactions){
                if(amount < 0){
                    System.out.println("Withdrawl Amount: " + amount);
                }
                else{
                    System.out.println("Deposit Amount: " + amount);
                }
            }
        }
        else
            System.out.println("No transactions for this customer.");
    }

    public void depositFunds(Double amount){
        this.getTransactions().add(amount);
        this.setCustomerBalance(this.getCustomerBalance() + amount);
        displayCustomerBalance();
    }

    public void withdrawFunds(Double amount){
        this.getTransactions().add(amount * -1);

        if(amount > this.getCustomerBalance())
            System.out.println("Not enough funds to withdraw: " + amount);
        else
            this.setCustomerBalance(this.getCustomerBalance() - amount);

        displayCustomerBalance();
    }

    public void displayCustomerBalance() {
        System.out.println("Current Balance: " + this.getCustomerBalance());
    }
}
