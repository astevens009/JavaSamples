package org.kemetkoder.astevens;

import java.text.NumberFormat;
import java.util.*;

public class Customer {
    // The following lines used to format US currency
    public static Locale usLocale = Locale.US;
    public static Currency usd = Currency.getInstance(usLocale);
    public static NumberFormat usdFormat = NumberFormat.getCurrencyInstance(usLocale);

    Scanner userInput = new Scanner(System.in);
    private String customerName;
    private double initialBalance;

    // NOTE: Using Autoboxing per lesson
    private Double customerBalance;

    private ArrayList<Transaction> customerTransactions = new ArrayList<Transaction>();

    public Customer(){

    }

    public Customer(String customerName, double initBalance) {
        this.customerName = customerName;
        this.initialBalance = initBalance;
        this.setCustomerBalance(this.initialBalance);
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getInitialBalance() {
        return initialBalance;
    }
    
    public void setInitialBalance(double initialBalance) {
		this.initialBalance = initialBalance;
	}

    /**
     * Using unboxing per lesson specs
     * @return
     */
	public double getCustomerBalance() {
        return customerBalance.doubleValue();
    }

    public void setCustomerBalance(double customerBalance) {
        this.customerBalance = customerBalance;
    }

    public Customer createNewCustomer(){
        // TODO: Get customer name
        System.out.println("Please enter the customer's name: ");
        setCustomerName(userInput.nextLine());

        // TODO: Get initial amount
        System.out.println("Please enter deposit amount: ");
        setInitialBalance(userInput.nextDouble());

        // TODO: Create the customer
        Customer bankCustomer = new Customer(getCustomerName(), getInitialBalance());
        return bankCustomer;
    }

    public String displayCustomerInfo(){
        return ("\nName: " + this.getCustomerName() +
                "\nBalance: " + usdFormat.format(this.getCustomerBalance()));
    }

    public void performTransaction(Transaction.TransactionType transaction, double amt){
        Transaction xAction = new Transaction();

        switch(transaction){
            case deposit:
                xAction.setTransType(Transaction.TransactionType.deposit);
                xAction.performDeposit(this, amt);
                customerTransactions.add(xAction);
                break;
            case withdrawl:
                xAction.setTransType(Transaction.TransactionType.withdrawl);
                xAction.performWithdrawl(this, amt);
                customerTransactions.add(xAction);
                break;
        }
    }

    /**
     * Using Autoboxing and unboxing in this demo, to correspond with lesson topic
     */
    public void showTransactions(){
        for(Transaction transx : customerTransactions){
            System.out.println("Transaction Type: " + transx.getTransType() +
                    "\nTransaction Amount: " + transx.getAmount().doubleValue());
            System.out.println();
        }
    }
}
