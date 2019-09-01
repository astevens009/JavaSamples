package org.kemetkoder.astevens;

import java.util.*;

public class MobilePhoneDemo2 {

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
			phone.addContact();
			break;
		case 'E':
		case 'e':{
			System.out.println("Please enter the name of the contact to edit:");
			String contactName = userInput.nextLine();
			phone.editContact(contactName);
		}
			break;
		case 'R':
		case 'r':
			// TODO: remove a contact
			phone.removeContact();
			break;
		case 'F':
		case 'f':{
			System.out.println("Please enter the name of the contact to find:");
			String contactName = userInput.nextLine();
			phone.findContact(contactName);
		}
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
