package org.kemetkoder.astevens;

import java.util.*;

public class MobilePhoneDemo {

	public static Scanner userInput = new Scanner(System.in);
	
	public static void main(String[] args) {
		MobilePhone mPhone = new MobilePhone();
		
		System.out.println("Welcome to Cyberdyne Telecommunication Systems");
		displayMenu(mPhone);
		
		
		//testContactList(mPhone);

	}

	private static void displayMenu(MobilePhone phone) {
		char userSelection = ' ';

		do {
		System.out.println("\nPlease select from the following:");
		
		System.out.println("D - Display contacts");
		System.out.println("A - Add a contact");
		System.out.println("E - Edit contact information");
		System.out.println("R - Remove a contact");
		System.out.println("F - Find a contact");
		System.out.println("Q - Quit");
		
		System.out.println("Enter your selection here:");
		userSelection = userInput.nextLine().charAt(0);
		
		processSelection(userSelection, phone);
		} while(userSelection != 'Q' && userSelection != 'q');
		
	}

	private static void processSelection(char userSelection, MobilePhone phone) {
		
		switch(userSelection) {
		case 'D':
		case 'd':
			// TODO: retrieve and display contacts
			phone.displayContacts();
			break;
		case 'A':
		case 'a':
			// TODO: add a new contact
			phone.addContact();
			break;
		case 'E':
		case 'e':
			// TODO: edit a contact
			System.out.println("Edit contact information to be implemented.");
			break;
		case 'R':
		case 'r':
			// TODO: remove a contact
			phone.removeContact();
			break;
		case 'F':
		case 'f':
			// TODO: find the contact
			System.out.println("Find a contact to be implemented.");
			break;
		case 'Q':
		case 'q':
			// TODO: quit
			System.out.println("Good-bye.");
			break;
		default:
			System.out.println("ERROR: " + userSelection + " is not valid.");
			break;
		}
		
	}

	
}
