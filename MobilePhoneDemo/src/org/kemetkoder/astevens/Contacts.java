package org.kemetkoder.astevens;

public class Contacts {
	//private String firstName;
	//private String lastName;
	private String name;
	private String phoneNumber;
	
	public Contacts() {
		
	}
	
//	public Contacts(String firstName, String lastName, String phoneNumber) {
//		super();
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.phoneNumber = phoneNumber;
//	}
	
	public Contacts(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}

	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
