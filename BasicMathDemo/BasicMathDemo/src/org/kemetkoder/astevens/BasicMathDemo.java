package org.kemetkoder.astevens;

import java.util.Scanner;

public class BasicMathDemo {
    public static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args) {
        DisplayMenu();
    }

    private static void DisplayMenu() {
        int option = 0;
        boolean goAgain = true;
        while(goAgain) {
            System.out.println("Please select from the following options:");
            System.out.println("1 - Addition");
            System.out.println("2 - Subtraction");
            System.out.println("3 - Multiplication");
            System.out.println("4 - Integer Division");
            System.out.println("5 - Division");
            System.out.println("0 - Exit");
            System.out.println("Enter your selection here: ");
            option = userInput.nextInt();

            switch(option){
                case 1:
                    PerformOperation("add");
                    break;
                case 2:
                    PerformOperation("subtract");
                    break;
                case 3:
                    PerformOperation("multiply");
                    break;
                case 4:
                    PerformOperation("intDivide");
                    break;
                case 5:
                    PerformOperation("divide");
                    break;
                case 0:
                default:
                    goAgain = false;
                    break;
            }
        }
    }

    private static void PerformOperation(String opr) {
        int num1, num2 = 0;

        System.out.println("Please enter the first number: ");
        num1 = userInput.nextInt();
        System.out.println("Now enter the second number: ");
        num2 = userInput.nextInt();

        switch(opr){
            case "add":
                System.out.printf("%d + %d = %d\n", num1, num2,
                        BasicMathematics.Addition(num1, num2));
                break;
            case "subtract":
                System.out.printf("%d - %d = %d\n", num1, num2,
                        BasicMathematics.Subtraction(num1, num2));
                break;
            case "multiply":
                System.out.printf("%d * %d = %d\n", num1, num2,
                        BasicMathematics.Multiplication(num1, num2));
                break;
            case "intDivide":
                PerformIntDivision(num1, num2);
                break;
            case "divide":
                PerformDivision(num1, num2);
                break;
        }
    }

    /**
     * Performing an implicit conversion of ints to doubles
     * @param num1 (integer) numerator input by user
     * @param num2 (integer) denominator input by user
     */
    private static void PerformDivision(int num1, int num2) {
        if(num2 == 0){
            System.out.println("ERROR: Cannot divide by 0");
        }
        else {
            double dNum1 = num1;
            double dNum2 = num2;
            System.out.printf("%.2f / %.2f = %.2f\n",dNum1, dNum2,
                    BasicMathematics.Division(dNum1, dNum2));
        }

    }

    /**
     * Perform integer division; loss of precision
     * @param num1 numerator input by user
     * @param num2 denominator input by user
     */
    private static void PerformIntDivision(int num1, int num2) {
        if(num2 == 0){
            System.out.println("ERROR: Cannot divide by 0");
        }
        else{
            System.out.printf("%d / %d = %d\n",num1, num2, BasicMathematics.Division(num1, num2));
        }
    }
}
