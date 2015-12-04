package models;

public class Contact {

	private int id;
	private String name;
	private String email;
	private String message;

	public Contact(String name, String email, String message) {
		this.name=name;
		this.email=email;
		this.message=message;
	}
	
	public int getId() {
		return this.id;
	}

	public String getIdAsString() {
		return Integer.toString(this.id);
	}

	
	public void setId(int newId) {
		this.id=newId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String newName) {
		this.name=newName;
	}

	public void setEmail(String newEmail) {
		this.email=newEmail;
	}

	public void setMessage(String newMessage) {
		this.message=newMessage;
	}



}
