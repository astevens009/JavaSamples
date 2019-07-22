package org.kemetkoder.astevens;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

import org.kemetkoder.astevens.Hamburger.Bread;
import org.kemetkoder.astevens.Hamburger.Meat;
import org.kemetkoder.astevens.Toppings.Topping;

public class Hamburger {
	
	public static Scanner userInput = new Scanner(System.in);
	
	// The following lines used to format US currency
	public static Locale usLocale = Locale.US;
	public static Currency usd = Currency.getInstance(usLocale);
	public static NumberFormat usdFormat = NumberFormat.getCurrencyInstance(usLocale);
	
	public enum Bread{
		hamburgerBun(0.00),
		bagel(0.20),
		slicedBread(0.10),
		brioche(0.25);
		
		private double breadPrice;
		
		Bread(double price){
			this.breadPrice = price;
		}
		
		double getBreadPrice() {
			return breadPrice;
		}
	}
	
	public enum Meat{

		beef(0.00),
		chicken(0.20),
		turkey(0.25),
		lamb(0.30);
		
		private double meatPrice;
		
		Meat(double price){
			this.meatPrice = price;
		}
		
		double getMeatPrice() {
			return meatPrice;
		}
	}

	private Bread custBreadSelection;
	private Meat custMeatSelection;
	private double burgerCost;
	private Toppings burgerTopping = new Toppings();
	
	
	public Hamburger() {
		this.setCustMeatSelection(Meat.beef);
		this.setCustBreadSelection(Bread.hamburgerBun);
	}
	
	public Hamburger(Bread custBreadSelection, 
			Meat custMeatSelection,
			double burgerPrice) {
		
	}

	public Bread getCustBreadSelection() {
		return custBreadSelection;
	}

	public void setCustBreadSelection(Bread custBreadSelection) {
		// TODO: reformat to display "human readable" names for the bread
		this.custBreadSelection = custBreadSelection;
	}

	public Meat getCustMeatSelection() {
		return custMeatSelection;
	}

	public void setCustMeatSelection(Meat custMeatSelection) {
		this.custMeatSelection = custMeatSelection;
	}

	public double getBurgerCost() {
		burgerCost += this.custBreadSelection.getBreadPrice() +
				this.custMeatSelection.getMeatPrice() +
				this.burgerTopping.calculateTotal();
		
		return burgerCost;
	}

	public void setBurgerCost(double burgerCost) {
		this.burgerCost = burgerCost;
	}

	public Toppings getBurgerTopping() {
		return burgerTopping;
	}

	public void setBurgerTopping(Toppings burgerTopping) {
		this.burgerTopping = burgerTopping;
	}
	
	public Meat getMeatSelection() {
		//Scanner meatInput = new Scanner(System.in);
		char meatChoice = ' ';
		Meat custMeatChoice;
		
		System.out.println("\nPlease select your choice of meat:");
		for(Meat mt : Meat.values()) {
			switch(mt) {
			case beef:
				if(mt.getMeatPrice() > 0)
					System.out.println("B - Beef (add " + 
							usdFormat.format(mt.getMeatPrice()) + ")");
				else
					System.out.println("B - Beef");
				break;
			case chicken:
				if(mt.getMeatPrice() > 0)
					System.out.println("C - Chicken (add " + 
							usdFormat.format(mt.getMeatPrice()) + ")");
				else
					System.out.println("C - Chicken");
				break;
			case turkey:
				if(mt.getMeatPrice() > 0)
					System.out.println("T - Turkey (add " + 
							usdFormat.format(mt.getMeatPrice()) + ")");
				else
					System.out.println("T - Turkey");
				break;
			case lamb:
				if(mt.getMeatPrice() > 0)
					System.out.println("L - Lamb (add " + 
							usdFormat.format(mt.getMeatPrice()) + ")");
				else
					System.out.println("L - Lamb");
				break;
			}
		}
		
		System.out.println("\nEnter your selection here: ");
		meatChoice = userInput.nextLine().charAt(0);
		
		switch(meatChoice) {
		case 'B':
		case 'b':
		default:
			custMeatChoice = Meat.beef;
			break;
		case 'C':
		case 'c':
			custMeatChoice = Meat.chicken;
			break;
		case 'T':
		case 't':
			custMeatChoice = Meat.turkey;
			break;
		case 'L':
		case 'l':
			custMeatChoice = Meat.lamb;
			break;
		}
		
		// TEST
		// System.out.println("Meat selected: " + custMeatChoice);
		
		return custMeatChoice;
	}

	public Bread getBreadSelection() {
		//Scanner breadInput = new Scanner(System.in);
		char breadChoice = ' ';
		Bread custBreadChoice;
		
		System.out.println("\nPlease select your choice of bread:");
		
		// Display the bread options
		for(Bread bd : Bread.values()) {
			switch(bd) {
			case hamburgerBun:
				if(bd.getBreadPrice() > 0)
					System.out.println("H - Hamburger Bun (add " + 
							usdFormat.format(bd.getBreadPrice()) + ")");
				else
					System.out.println("H - Hamburger Bun");
				break;
			case bagel:
				if(bd.getBreadPrice() > 0)
					System.out.println("B - Bagel (add " + 
							usdFormat.format(bd.getBreadPrice()) + ")");
				else
					System.out.println("B - Bagel");
				break;
			case slicedBread:
				if(bd.getBreadPrice() > 0)
					System.out.println("S - Sliced Bread (add " + 
							usdFormat.format(bd.getBreadPrice()) + ")");
				else
					System.out.println("S - Sliced Bread");
				break;
			case brioche:
				if(bd.getBreadPrice() > 0)
					System.out.println("R - Brioche (add " + 
							usdFormat.format(bd.getBreadPrice()) + ")");
				else
					System.out.println("R - Brioche");
				break;
			}
		}
		
		System.out.println("Enter your selection here: ");
		breadChoice = userInput.nextLine().charAt(0);
		
		// TODO: use a switch statement to get the bread
		switch(breadChoice) {
		case 'H':
		case 'h':
		default:
			custBreadChoice = Bread.hamburgerBun;
			break;
			//breadInput.close();
			//return Bread.hamburgerBun;
		case 'B':
		case 'b':
			custBreadChoice = Bread.bagel;
			break;
			//breadInput.close();
			//return Bread.bagel;
		case 'S':
		case 's':
			custBreadChoice = Bread.slicedBread;
			break;
			//breadInput.close();
			//return Bread.slicedBread;
		case 'R':
		case 'r':
			custBreadChoice = Bread.brioche;
			break;
			//breadInput.close();
			//return Bread.brioche;
		}
		
		return custBreadChoice;
	}


}
