public class Client {
	private String name;
	private String surname;
	
	public Client() {
		
	}
	
	public Client(String fullName) {
		String[] parts=fullName.split(",");
		surname=parts[0].trim();
		name=parts[1].trim();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
}
