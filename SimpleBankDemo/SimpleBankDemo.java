package org.kemetkoder.astevens;

import java.util.*;

public class SimpleBankDemo {
    static Scanner userInput = new Scanner(System.in);
    
    public static void main(String[] args) {
        char bankOption = ' ';
        Branch branch = new Branch();
        Bank bank = new Bank();

        System.out.println("\n\nWelcome to Kemet Banking Solutions" +
                "\nPlease select from the following options:");
        displayBankingMenu(bank, branch);

        //================================= TESTS =================================
            // TestCases tester = new TestCases();
            // tester.createCustomerTest();
            // tester.bankBranchTest();
            // tester.bankTest(branch);
            // tester.bankCustomerTest();
        //================================= TESTS =================================


    }

    private static void performOption(char bankOption, Branch bankBranch) {
        Bank bank = new Bank();
        
        // NOTE: Associate the branch to this bank
        bank.setBankBranch(bankBranch);
        
        bankOption = Character.toUpperCase(bankOption);

        switch(bankOption){
            // TODO: Remember to create some validation here
            case 'C':
                System.out.println("Please enter the branch name: ");
                String branchName = userInput.nextLine();

                System.out.println("Please enter the branch region: ");
                String branchRegion = userInput.nextLine();

                bankBranch = bank.createBranch(branchName, branchRegion);
                bank.setBankBranch(bankBranch);
                System.out.println("\nTEST - performOption:\nBranch Name: " + bankBranch.getBranchName());
//                System.out.println("\nTEST:\nBranch Name: " + bankBranch.getBranchName() +
//                        "\nBranch Region: " + bankBranch.getBranchRegion());
                break;
            case 'A':
                // Display a list of branches if there is more than one branch
                if(bank.getBranchList().size() > 1) {
                    bankBranch = selectBranch(bank);
                }

                // NOTE: Update the bank branch with the new customer information
                bankBranch = bank.processNewCustomer(bankBranch);
                bank.setBankBranch(bankBranch);

                break;
            case 'L':
                if(bank != null)
                    bank.displayCustomers(bankBranch);
                else
                    System.out.println("There is no bank information to display.");
                break;
            case 'P':
                bank.setBankBranch(bankBranch);
                bank.processCustomerTransaction();
                break;
            default:
                System.out.println("Invalid selection - " + bankOption);
                break;
        }
    }

    /**
     * Update the branch and return it to the calling function
     * @param bankOption
     * @return
     */
    private static Branch performOption(Bank bank, Branch bankBranch, char bankOption) {
        // Bank bank = new Bank();
        //Branch bankBranch = new Branch();

        // NOTE: Associate the branch to this bank
        bank.setBankBranch(bankBranch);

        bankOption = Character.toUpperCase(bankOption);

        switch(bankOption){
            // TODO: Remember to create some validation here
            case 'C':
                System.out.println("Please enter the branch name: ");
                String branchName = userInput.nextLine();

                System.out.println("Please enter the branch region: ");
                String branchRegion = userInput.nextLine();

                bankBranch = bank.createBranch(branchName, branchRegion);
                bank.setBankBranch(bankBranch);
//                System.out.println("\nTEST - performOption:\nBranch Name: " + bankBranch.getBranchName());
//                System.out.println("\nTEST:\nBranch Name: " + bankBranch.getBranchName() +
//                        "\nBranch Region: " + bankBranch.getBranchRegion());
                break;
            case 'A':
                // Display a list of branches if there is more than one branch
                if(bank.getBranchList().size() > 1) {
                    bankBranch = selectBranch(bank);
                }

                // NOTE: Update the bank branch with the new customer information
                bankBranch = bank.processNewCustomer(bankBranch);
                bank.setBankBranch(bankBranch);

                break;
            case 'L':
                if(bank != null) {
                    // Display a list of branches if there is more than one branch
                    if (bank.getBranchList().size() > 1) {
                        bankBranch = selectBranch(bank);
                    }

                    bank.displayCustomers(bankBranch);
                }
                else
                    System.out.println("There is no bank information to display.");
                break;
            case 'P':
                bank.setBankBranch(bankBranch);
                bank.processCustomerTransaction();
                break;
            default:
                System.out.println("Invalid selection - " + bankOption);
                break;
        }

        return bankBranch;
    }

    private static Branch selectBranch(Bank bank) {
        int menuOpt;
        int selectedBranch;

        System.out.println("\nSelect a branch to add an account to:");
        for (Branch br : bank.getBranchList()) {
            menuOpt = (bank.getBranchList().indexOf(br) + 1);
            System.out.println(menuOpt + " - " + br.getBranchName());
        }

        // TODO: Select bank branch
        System.out.println("\nEnter your selection here: ");
        selectedBranch = userInput.nextInt();
        userInput.nextLine();       // Catch extraneous newline character
        Branch bankBranch = bank.getBranchList().get(selectedBranch - 1);

        return bankBranch;
    }

    private static void displayBankingMenu(Bank bank, Branch bankBranch) {
        char userResponse = 'N';
        char userSelection = ' ';

        do {
            // The following line would likely be something that would require admin access
            System.out.println("\nC - Create a new branch (Administrator Only)");
            System.out.println("A - Add a new account");
            // The following line would likely be something that would require admin access
            System.out.println("L - List customers (Administrator Only)");
            System.out.println("P - Process a transaction");

            System.out.println("Please enter your selection here: ");
            userSelection = userInput.nextLine().charAt(0);

            //performOption(userSelection, bankBranch);
            bankBranch = performOption(bank, bankBranch, userSelection);      // NOTE: Get the updated branch information
            bank.setBankBranch(bankBranch);

            // TEST...
            // System.out.println("\nTEST - displayBankingMenu:\nBranch Name: " + bankBranch.getBranchName());
            // TestCases tester = new TestCases();
            // tester.multipleBranchTest(bank);

            System.out.println("Would you like another transaction? (Y/N)");
            userResponse = userInput.nextLine().charAt(0);
            userResponse = Character.toUpperCase(userResponse);

        }while(userResponse == 'Y');

        System.out.println("\nThank you for using Kemet Banking Solutions");
    }

}
