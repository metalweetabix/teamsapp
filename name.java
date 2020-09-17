package model;

public class name {
	private String firstname;
	private String middlename;
	private String lastname;
	
	public name(String name1, String name2, String name3) {
		this.setFirstname(name1);
		this.setMiddlename(name2);
		this.setLastname(name3);
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String toString() {
		return firstname + " " + middlename + " " + lastname;
	}
	
}
