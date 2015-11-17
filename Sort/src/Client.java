import java.util.Date;

public class Client implements Comparable<Client> {

	private String name;
	private String surName;
	private Date birthDate;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public int compareTo(Client otherClient) {
		int compareSurname=otherClient.surName.compareTo(surName);
		if (compareSurname!=0) return compareSurname;
		int compareName=name.compareTo(otherClient.name);
		if (compareName!=0) return compareName;
		return birthDate.compareTo(otherClient.birthDate);
	}
	
	
	
}
