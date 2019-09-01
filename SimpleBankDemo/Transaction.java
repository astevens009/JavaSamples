package org.kemetkoder.astevens;

/**
 * Using Autoboxing and unboxing in this demo, to correspond with lesson topic
 */
public class Transaction {
    public enum TransactionType{
        deposit,
        withdrawl
    }

    //Customer bankCustomer = new Customer();

    private TransactionType transType;
    private Double amount;      // NOTE: Using Autoboxing per lesson spec

    public TransactionType getTransType() {
        return transType;
    }

    public void setTransType(TransactionType transType) {
        this.transType = transType;
    }

    /**
     * Using unboxing, per lesson
     * @return
     */
    public Double getAmount() {
        return amount.doubleValue();
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * Returns the Customer object to allow for confirmation of changes to account
     * @param cust
     * @param amt
     * @return
     */
    public Customer performDeposit(Customer cust, double amt){

        // Track amount deposited
        setAmount(amt);

        // Add new amount to the current balance
        cust.setCustomerBalance(cust.getCustomerBalance() + amt);

        return cust;
    }

    public boolean performWithdrawl(Customer cust, double amt){
        boolean withdrawlSuccess = false;

        if(cust.getCustomerBalance() < amt)
            System.out.println("Not enough funds to withdraw " + amt);
        else {
            // Track amount withdrawn
            /*
            NOTE:
            Per the lesson the amount variable could also be assigned this way:
            amount = new Double(amt);
             */
            amount = amt;

            cust.setCustomerBalance(cust.getCustomerBalance() - amt);
            withdrawlSuccess = true;
        }

        return withdrawlSuccess;
    }

    /**
     * Displays a menu of transactions based on the enumerated type above
     */
    public void transactionMenu(){
        for(TransactionType trType : TransactionType.values()){
            switch(trType){
                case deposit:
                    System.out.println("D - Deposit");
                    break;
                case withdrawl:
                    System.out.println("W - Withdrawl");
                    break;
            }
        }
    }
}
