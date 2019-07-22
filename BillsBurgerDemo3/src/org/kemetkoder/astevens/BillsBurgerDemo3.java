package org.kemetkoder.astevens;

import java.text.NumberFormat;
import java.util.*;

import org.kemetkoder.astevens.Hamburger.Bread;
import org.kemetkoder.astevens.Hamburger.Meat;

public class BillsBurgerDemo3 {
	
	// The following lines used to format US currency
	public static Locale usLocale = Locale.US;
	public static Currency usd = Currency.getInstance(usLocale);
	public static NumberFormat usdFormat = NumberFormat.getCurrencyInstance(usLocale);
	
	// Used to set the price for the burgers
	public final static double HAMBURGERPRICE = 1.25;
	public final static double HEALTHYBURGERPRICE = 1.50;
	public final static double DELUXEBURGERPRICE = 1.75;
	
	public static Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		
		//testToppingsMenu();
		displayBurgerMenu();

		userInput.close();
	}

	private static void testToppingsMenu() {
		Toppings toppings = new Toppings();
		
		toppings.displayToppingsMenu();
	}
	
	private static void displayBurgerMenu() {
		System.out.println("Please select your burger:");
		System.out.println("R - Hamburger ----- " + 
				usdFormat.format(HAMBURGERPRICE));
		System.out.println("H - Healthy Burger ----- " + 
				usdFormat.format(HEALTHYBURGERPRICE));
		System.out.println("D - Deluxe Burger ----- " + 
				usdFormat.format(DELUXEBURGERPRICE));
		
		// TEST - Checking the class of the burger
		try {
			Hamburger customerBurger = getCustomerSelection();
			// System.out.println("\nTEST: Class = " + h.getClass().getSimpleName());
			printReceipt(customerBurger);
			System.out.println("\nThe cost of the burger is: " + orderTotal(customerBurger));
		}
		catch(NullPointerException npe) {
			System.out.println(npe.getMessage());
		}
	}

	private static void printReceipt(Hamburger burger) {
		
		// TODO: Remember to include a listing of the toppings
		System.out.println("\nReceipt:\nSelected Meat: " + burger.getCustMeatSelection() +
				 "\nSelected Bread: " + burger.getCustBreadSelection());
		
	}

	private static Hamburger getCustomerSelection() {
		Hamburger burger;
		
		//Scanner burgerInput = new Scanner(System.in);
		
		System.out.print("\nEnter your selection here: ");
		char customerSelection = userInput.nextLine().charAt(0);
		
		// TODO: process order by displaying the bread and meat menu and 
		// prompting the customer for desired toppings
		switch(customerSelection) {
			case 'R':
			case 'r':
			{
				burger = new Hamburger();
				burger.setBurgerCost(HAMBURGERPRICE);				
				burger.setCustBreadSelection(burger.getBreadSelection());
				burger.setCustMeatSelection(burger.getMeatSelection());
				return burger;
			}
			case 'H':
			case 'h':
			{
				burger = new HealthyBurger();
				burger.setBurgerCost(HEALTHYBURGERPRICE);
				return burger;
			}
			case 'D':
			case 'd':
			{
				burger = new DeluxeBurger();
				burger.setBurgerCost(DELUXEBURGERPRICE);
				return burger;
			}
			default:
			{
				burger = null;
				System.out.println("ERROR: Invalid selection");
				return burger;
			}
		}
	}

	
	public static double orderTotal(Hamburger burger) {
		double total = 0.0;
		
		total += burger.getBurgerCost() + 
				burger.getBurgerTopping().calculateTotal();
				
		
		return total;
	}
}
