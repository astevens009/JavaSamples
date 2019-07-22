package org.kemetkoder.astevens;

import java.text.NumberFormat;
import java.util.*;

public class Toppings {
	public final int MAXTOPCOUNT = 4;
	
	// The following lines used to format US currency
	public static Locale usLocale = Locale.US;
	public static Currency usd = Currency.getInstance(usLocale);
	public static NumberFormat usdFormat = NumberFormat.getCurrencyInstance(usLocale);
	
	public enum Topping{
		cheese (0.10),
		pickles(0.10),
		lettuce(0.10),
		tomato(0.15),
		onion(0.15),
		mayonnaise(0.10),
		mustard(0.10);
		
		private double toppingPrice;
		
		Topping(double price){
			this.toppingPrice = price;
		}
		
		double getToppingPrice() {
			return toppingPrice;
		}
	}
	
	int toppingCount = 0; 	// customer can only have up to 4 toppings
	Topping burgerTopping;
	ArrayList<Topping> toppingsList = new ArrayList<Topping>();
	
	public Toppings() {
		
	}
	
	public Toppings(Topping burgerTopping) {
		super();
		this.burgerTopping = burgerTopping;
	}
	
	public void displayToppingsMenu() {
		
		for(Topping tp : Topping.values()) {
			switch(tp) {
			case cheese:
				System.out.println("C - Cheese (add " + 
				usdFormat.format(tp.getToppingPrice()) + ")");
				break;
			case pickles:
				System.out.println("P - Pickles (add " + 
				usdFormat.format(tp.getToppingPrice()) + ")");
				break;
			case lettuce:
				System.out.println("L - Lettuce (add " + 
				usdFormat.format(tp.getToppingPrice()) + ")");
				break;
			case tomato:
				System.out.println("T - Tomato (add " + 
				usdFormat.format(tp.getToppingPrice()) + ")");
				break;
			case onion:
				System.out.println("O - Onion (add " + 
				usdFormat.format(tp.getToppingPrice()) + ")");
				break;
			case mayonnaise:
				System.out.println("Y - Mayonnaise (add " + 
				usdFormat.format(tp.getToppingPrice()) + ")");
				break;
			case mustard:
				System.out.println("M - Mustard (add " + 
				usdFormat.format(tp.getToppingPrice()) + ")");
				break;
			}
	
		}
	}
	
	public void addTopping(Topping topping) {
		if(toppingCount == 4) {
			System.out.println("\nMaximum toppings " + MAXTOPCOUNT + " reached");
		}
		else {
			toppingsList.add(topping);
			toppingCount++;
		}
	}
	
	public double calculateTotal() {
		double toppingsTotal = 0.0;
		
		for(Topping tp : toppingsList)
			toppingsTotal += tp.getToppingPrice();
		
		return toppingsTotal;
	}
}
