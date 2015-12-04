package adapters;

import java.util.ArrayList;

import models.Contact;

public class ContactRepository {
	private static int lastGeneratedId=0;
	
	private ArrayList<Contact> contacts=new ArrayList<Contact>();
	
	public Contact save(Contact newContact) {
		int newGeneratedId=lastGeneratedId++;
		newContact.setId(newGeneratedId);
		contacts.add(newContact);
		return newContact;
	}

	public Contact findById(int id) {
		for(Contact contact:contacts) {
			if (contact.getId()==id) return contact;
		}
		return null;
	}

}
