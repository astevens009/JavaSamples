package org.kemetkoder.astevens;

public class Contact {
	
	//private String firstName;
		//private String lastName;
		private String name;
		private String phoneNumber;
		
		public Contact() {
			
		}
		
//		public Contacts(String firstName, String lastName, String phoneNumber) {
//			super();
//			this.firstName = firstName;
//			this.lastName = lastName;
//			this.phoneNumber = phoneNumber;
//		}
		
		public Contact(String name, String phoneNumber) {
			super();
			this.name = name;
			this.phoneNumber = phoneNumber;
		}

//		public String getFirstName() {
//			return firstName;
//		}
	//
//		public void setFirstName(String firstName) {
//			this.firstName = firstName;
//		}
	//
//		public String getLastName() {
//			return lastName;
//		}
	//
//		public void setLastName(String lastName) {
//			this.lastName = lastName;
//		}

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
		
		/**
		 * Factory method - 
		 * Use this to create new contacts without having to instantiate the 
		 * Contact() object
		 * @param name
		 * @param phNumber
		 * @return
		 */
		public static Contact createContact(String name, String phNumber) {
			return new Contact(name, phNumber);
		}

}
