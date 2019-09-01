package org.kemetkoder.astevens;

import java.util.*;

public class MobilePhone {
	
	public Scanner userInput = new Scanner(System.in);
	private Contact phoneContact = new Contact();
	private ArrayList<Contact> userContacts = new ArrayList<Contact>();
	
	public ArrayList<Contact> getUserContacts() {
		return userContacts;
	}
	
	public void removeContact() {

		String contactName = "";
	
		if(this.getUserContacts().isEmpty())
			System.out.println("No contacts available.");
		else {			
			System.out.println("Please enter contact's name:");
			contactName = userInput.nextLine();
					
			// TODO: retrieve and display the contact
			int recordIndex = retrieveContact(contactName);
			
			System.out.println("Remove contact: ");
			displayContactInfo(recordIndex);

			// TODO: confirm removal
			char response = 'N';
			
			if(recordIndex != -1)
				System.out.println("\nOK to remove? (Y/N)");
				response = userInput.nextLine().charAt(0);
				
			// TODO: remove contact
			if(response == 'Y' || response == 'y') {
				try {
					this.getUserContacts().remove(recordIndex);
					System.out.println("Contact successfully removed.");
				}
				catch(IndexOutOfBoundsException iob) {
					System.out.println(iob.getMessage());
				}
			}
		}
		
	}
	
	private void displayContactInfo(int retrieveContact) {
		
		if(retrieveContact != -1) {
			System.out.println("\nName: " +
					this.getUserContacts().get(retrieveContact).getName() +
					"\nPhone Number: " + 
					this.getUserContacts().get(retrieveContact).getPhoneNumber());
		}
		else
			System.out.println("\nContact not found.");
		
	}

	/**
	 * Return the index of the record to be deleted or updated
	 * @param contactName
	 * @return
	 */
	private int retrieveContact(String contactName) {
		
		int contactIndex = -1;
		
		for(Contact cnt : this.getUserContacts()) {
			
			if(cnt.getName().equals(contactName))
				contactIndex = this.getUserContacts().indexOf(cnt);
		}
	
		return contactIndex;
	}

	public void displayContacts() {
		
		if(this.getUserContacts().isEmpty())
			System.out.println("No contacts available.");
		else {
			System.out.println("Contact List:\n");
			for(Contact c : this.getUserContacts())
				System.out.println(c.getName() + "\n" + c.getPhoneNumber() + "\n");
		}
		
	}
	
	public void displayContact(int contactIndex) {
		
		Contact contactToDisplay = this.getUserContacts().get(contactIndex);
		
		System.out.println("Contact Info:\nName: " + contactToDisplay.getName() +
				"\nPhone Number: " + contactToDisplay.getPhoneNumber());
	}

	public void addContact() {
		char response = 'Y';
		Contact contact;
		
		do {
			contact = new Contact();
			
			System.out.println("Enter the contact's full name: ");
			contact.setName(userInput.nextLine());
			
			if(this.retrieveContact(contact.getName()) >= 0)
				System.out.println(contact.getName() + " already exists.");
			else {
				System.out.println("Enter the contact's phone number: ");
				contact.setPhoneNumber(userInput.nextLine());
				this.userContacts.add(contact);
			}
				
			System.out.println("Add another? (Y/N)");
			response = userInput.nextLine().charAt(0);
		
		} while(response == 'Y' || response == 'y');

	}
	
	// TODO: Make sure to modify for multiple people with the same name
	public boolean editContact(String contactName) {
		
		boolean edited = false;
		char response = ' ';
		int contactIndex = this.retrieveContact(contactName);
		
		displayContact(contactIndex);
		
		if(contactIndex != -1) {
			System.out.println("Would you like to change the contact name? (Y/N)");
			response = userInput.nextLine().charAt(0);
			
			if(response == 'Y' || response == 'y') {
				modifyContactName(contactIndex, contactName);
				edited = modifyContactConfirm(contactIndex);
			}
			
			System.out.println("Would you like to change the contact phone number? (Y/N)");
			response = userInput.nextLine().charAt(0);
			
			if(response == 'Y' || response == 'y') {
				modifyConactPhoneNumber(contactIndex, contactName);
				edited = modifyContactConfirm(contactIndex);
			}
		}
		
		
		return edited;
	}

	private boolean modifyContactConfirm(int contactIndex) {
		
		boolean edited = false;
		
		// Confirm changes
		System.out.println("The contact information has been updated:\n");
		displayContact(contactIndex);
		edited = true;
		
		return edited;
		
	}

	// TODO: Modify this to accept a contact object with the changes and then
	// update the contact object rather than the individual fields
	private void modifyConactPhoneNumber(int contactIndex, String contactName) {
		String newPhoneNumber = "";
		
		System.out.println("Please enter the new phone number: ");
		newPhoneNumber = userInput.nextLine();
		
		// Retrieve the old information
		phoneContact = this.getUserContacts().get(contactIndex);
		
		// Modify the information
		phoneContact.setPhoneNumber(newPhoneNumber);;
		
		// Save changes
		this.getUserContacts().set(contactIndex, phoneContact);
	}

	private void modifyContactName(int contactIndex, String contactName) {
		String newName = "";
		
		System.out.println("Please enter the new name: ");
		newName = userInput.nextLine();
		
		// Retrieve the old information
		phoneContact = this.getUserContacts().get(contactIndex);
		
		// Modify the information
		phoneContact.setName(newName);
		
		// Save changes
		this.getUserContacts().set(contactIndex, phoneContact);
		
	}
	
	public void findContact(String contactName) {
		
		int contactIndex = this.retrieveContact(contactName);
		
		if(contactIndex != -1)
			this.displayContact(contactIndex);
		else
			System.out.println("Contact not found.");
		
	}

}
