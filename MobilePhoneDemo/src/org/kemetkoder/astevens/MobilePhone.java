package org.kemetkoder.astevens;

import java.util.*;

public class MobilePhone {
	
	public Scanner userInput = new Scanner(System.in);
	private Contacts phoneContact = new Contacts();
	private ArrayList<Contacts> userContacts = new ArrayList<Contacts>();
	
	public ArrayList<Contacts> getUserContacts() {
		return userContacts;
	}
	
	public void removeContact() {
		
//		String firstName = "";
//		String lastName = "";
		
		String contactName = "";
	
		if(this.getUserContacts().isEmpty())
			System.out.println("No contacts available.");
		else {
			// TODO: get the contact to remove
//			System.out.println("Please enter the contact's first name:");
//			firstName = userInput.nextLine(); 
//			
//			System.out.println("Please enter the contact's last name:");
//			lastName = userInput.nextLine(); 
			
			System.out.println("Please enter contact's name:");
			contactName = userInput.nextLine();
					
			// TODO: retrieve and display the contact
			if(userContacts.contains(contactName)){
				System.out.println("Name: " + 
						userContacts.get(userContacts.indexOf(contactName)).getName() + 
						"\nPhone Number: " +
						userContacts.get(userContacts.indexOf(contactName)).getPhoneNumber());
			}

			// TODO: confirm removal
			
			// TODO: remove contact
		}
		
	}

//	public void displayContacts() {
//		
//		if(this.getUserContacts().isEmpty())
//			System.out.println("No contacts available.");
//		else {
//			System.out.println("Contact List:\n");
//			for(Contacts c : this.getUserContacts())
//				System.out.println(c.getLastName() + ", " + 
//						c.getFirstName() + "\n" +
//						c.getPhoneNumber() + "\n");
//		}
//		
//	}
	

	public void displayContacts() {
		
		if(this.getUserContacts().isEmpty())
			System.out.println("No contacts available.");
		else {
			System.out.println("Contact List:\n");
			for(Contacts c : this.getUserContacts())
				System.out.println(c.getName() + "\n" + c.getPhoneNumber() + "\n");
		}
		
	}

//	public void addContact() {
//		char response = 'Y';
//		Contacts contact;
//		
//		do {
//			contact = new Contacts();
//			
//			System.out.println("Enter the contact's first name: ");
//			contact.setFirstName(userInput.nextLine());
//			
//			System.out.println("Enter the contact's last name: ");
//			contact.setLastName(userInput.nextLine());
//			
//			System.out.println("Enter the contact's phone number: ");
//			contact.setPhoneNumber(userInput.nextLine());
//			
//			this.userContacts.add(contact);
//			
//			System.out.println("Add another? (Y/N)");
//			response = userInput.nextLine().charAt(0);
//		
//		} while(response == 'Y' || response == 'y');
//
//	}


	public void addContact() {
		char response = 'Y';
		Contacts contact;
		
		do {
			contact = new Contacts();
			
			System.out.println("Enter the contact's first name: ");
			contact.setName(userInput.nextLine());
			
			System.out.println("Enter the contact's phone number: ");
			contact.setPhoneNumber(userInput.nextLine());
			
			this.userContacts.add(contact);
			
			System.out.println("Add another? (Y/N)");
			response = userInput.nextLine().charAt(0);
		
		} while(response == 'Y' || response == 'y');

	}

	
}
